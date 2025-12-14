package com.api.almoxarifado.services;

import com.api.almoxarifado.models.Ferramenta;
import com.api.almoxarifado.repositories.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FerramentaService {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    public List<Ferramenta> listarTodas() {
        return ferramentaRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<Ferramenta> buscarPorId(Long id) {
        return ferramentaRepository.findById(id);
    }

    public Ferramenta salvar(Ferramenta ferramenta) {
        ferramenta.setDataCadastro(LocalDateTime.now());
        return ferramentaRepository.save(ferramenta);
    }

    @SuppressWarnings("null")
    public Ferramenta atualizar(Long id, Ferramenta ferramenta) {
        if (ferramentaRepository.existsById(id)) {
            Optional<Ferramenta> ferramentaExistente = ferramentaRepository.findById(id);
            if (ferramentaExistente.isPresent()) {
                Ferramenta ferramentaAtual = ferramentaExistente.get();
                ferramenta.setId(id);
                ferramenta.setDataCadastro(ferramentaAtual.getDataCadastro()); // Mantém a data de cadastro original
                ferramenta.setDataAtualizacao(LocalDateTime.now());
                return ferramentaRepository.save(ferramenta);
            }
        }
        return null;
    }

    @SuppressWarnings("null")
    public void deletar(Long id) {
        ferramentaRepository.deleteById(id);
    }
}
