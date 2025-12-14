package com.api.almoxarifado.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovimentacaoDevolucaoDTO {

    private Long ferramentaId;
    private Integer quantidade;
    private String responsavel;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataMovimentacao;

    private Long movimentacaoOriginal;


    public Long getFerramentaId() {
        return this.ferramentaId;
    }

    public void setFerramentaId(Long ferramentaId) {
        this.ferramentaId = ferramentaId;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDateTime getDataMovimentacao() {
        return this.dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Long getMovimentacaoOriginal() {
        return this.movimentacaoOriginal;
    }

    public void setMovimentacaoOriginal(Long movimentacaoOriginal) {
        this.movimentacaoOriginal = movimentacaoOriginal;
    }
    
}
