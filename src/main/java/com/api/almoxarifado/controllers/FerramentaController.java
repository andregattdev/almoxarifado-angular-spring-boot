package com.api.almoxarifado.controllers;

import com.api.almoxarifado.models.Ferramenta;
import com.api.almoxarifado.services.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ferramentas")
@CrossOrigin(origins = "http://localhost:4200")
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    @GetMapping
    public List<Ferramenta> listarTodas() {
        return ferramentaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ferramenta> buscarPorId(@PathVariable Long id) {
        return ferramentaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ferramenta salvar(@RequestBody Ferramenta ferramenta) {
        return ferramentaService.salvar(ferramenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ferramenta> atualizar(@PathVariable Long id, @RequestBody Ferramenta ferramenta) {
        Ferramenta ferramentaAtualizada = ferramentaService.atualizar(id, ferramenta);
        if (ferramentaAtualizada != null) {
            return ResponseEntity.ok(ferramentaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ferramentaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}