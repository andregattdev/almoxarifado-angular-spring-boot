package com.api.almoxarifado.controllers;

import com.api.almoxarifado.dto.MovimentacaoDevolucaoDTO;
import com.api.almoxarifado.models.MovimentacaoEstoque;
import com.api.almoxarifado.services.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimentacoes")
@CrossOrigin(origins = "localhost:4200")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueService movimentacaoService;

    @GetMapping
    public ResponseEntity<List<MovimentacaoEstoque>> listarTodas() {
        return ResponseEntity.ok(movimentacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoque> buscarPorId(@PathVariable Long id) {
        return movimentacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> registrarMovimentacao(@RequestBody MovimentacaoEstoque movimentacao) {
        try {
            MovimentacaoEstoque novaMovimentacao = movimentacaoService.registrarMovimentacao(movimentacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaMovimentacao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Return error message
        }
    }

    @PostMapping("/{id}/devolucao")
    public ResponseEntity<?> registrarDevolucao(
            @PathVariable Long id,
            @RequestBody MovimentacaoDevolucaoDTO dto) {
        try {
            MovimentacaoEstoque novaDevolucao = movimentacaoService.registrarDevolucao(id, dto);
            return ResponseEntity.ok(novaDevolucao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}