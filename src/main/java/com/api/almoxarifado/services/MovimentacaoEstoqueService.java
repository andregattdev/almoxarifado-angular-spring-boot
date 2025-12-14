package com.api.almoxarifado.services;

import com.api.almoxarifado.dto.MovimentacaoDevolucaoDTO;
import com.api.almoxarifado.models.Ferramenta;
import com.api.almoxarifado.models.MovimentacaoEstoque;
import com.api.almoxarifado.models.TipoMovimentacao;
import com.api.almoxarifado.repositories.MovimentacaoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoRepository;

    @Autowired
    private FerramentaService ferramentaService;

    public List<MovimentacaoEstoque> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<MovimentacaoEstoque> buscarPorId(Long id) {
        return movimentacaoRepository.findById(id);
    }

    public MovimentacaoEstoque registrarMovimentacao(MovimentacaoEstoque movimentacao) {

        Optional<Ferramenta> ferramentaOpt = ferramentaService.buscarPorId(movimentacao.getFerramenta().getId());

        if (ferramentaOpt.isEmpty()) {
            throw new RuntimeException("Ferramenta não encontrada");
        }

        Ferramenta ferramenta = ferramentaOpt.get();
        int quantidadeAtual = ferramenta.getQuantidade();

        if (movimentacao.getTipoMovimentacao().isEntrada()) {
            ferramenta.setQuantidade(quantidadeAtual + movimentacao.getQuantidade());
        } else {
            if (quantidadeAtual < movimentacao.getQuantidade()) {
                throw new RuntimeException("Quantidade insuficiente em estoque");
            }
            ferramenta.setQuantidade(quantidadeAtual - movimentacao.getQuantidade());
        }

        Ferramenta ferramentaAtualizada = ferramentaService.atualizar(ferramenta.getId(), ferramenta);

        movimentacao.setFerramenta(ferramentaAtualizada);
        movimentacao.setDataMovimentacao(LocalDateTime.now());

        return movimentacaoRepository.save(movimentacao);
    }

    public MovimentacaoEstoque registrarDevolucao(Long idOriginal, MovimentacaoDevolucaoDTO dto) {

    @SuppressWarnings("null")
    MovimentacaoEstoque movimentacaoOriginal = movimentacaoRepository.findById(idOriginal)
            .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));

    if (movimentacaoOriginal.getTipoMovimentacao() != TipoMovimentacao.SAIDA) {
        throw new RuntimeException("Apenas movimentações de saída podem ser devolvidas");
    }

    if (movimentacaoOriginal.getDataDevolucao() != null) {
        throw new RuntimeException("Esta ferramenta já foi devolvida");
    }

    // Atualiza a movimentação original
    movimentacaoOriginal.setDataDevolucao(LocalDateTime.now());
    movimentacaoOriginal.setResponsavelDevolucao(dto.getResponsavel());

    // Cria nova movimentação de devolução
    MovimentacaoEstoque novaDevolucao = new MovimentacaoEstoque();
    novaDevolucao.setFerramenta(movimentacaoOriginal.getFerramenta());
    novaDevolucao.setTipoMovimentacao(TipoMovimentacao.DEVOLUCAO);
    novaDevolucao.setQuantidade(dto.getQuantidade());
    novaDevolucao.setResponsavel(dto.getResponsavel());
    novaDevolucao.setDataMovimentacao(dto.getDataMovimentacao());
    novaDevolucao.setMovimentacaoOriginal(idOriginal);

    // Atualiza estoque
    Ferramenta ferramenta = movimentacaoOriginal.getFerramenta();
    ferramenta.setQuantidade(ferramenta.getQuantidade() + dto.getQuantidade());
    ferramentaService.atualizar(ferramenta.getId(), ferramenta);

    movimentacaoRepository.save(movimentacaoOriginal);
    return movimentacaoRepository.save(novaDevolucao);
}
}