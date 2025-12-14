package com.api.almoxarifado.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimentacoes_estoque")
public class MovimentacaoEstoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ferramenta_id", nullable = false)
    private Ferramenta ferramenta;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacao tipoMovimentacao;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_movimentacao")
    private LocalDateTime dataMovimentacao;
    
    @Column(nullable = false)
    private String responsavel;

    @Column(name = "movimentacao_original")
    private Long movimentacaoOriginal;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;
    
    @Column(name = "responsavel_devolucao")
    private String responsavelDevolucao;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Ferramenta getFerramenta() {
        return ferramenta;
    }
    
    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }
    
    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    
    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }
    
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
    
    public String getResponsavel() {
        return responsavel;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getMovimentacaoOriginal() {
        return movimentacaoOriginal;
    }

    public void setMovimentacaoOriginal(Long movimentacaoOriginal) {
        this.movimentacaoOriginal = movimentacaoOriginal;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getResponsavelDevolucao() {
        return responsavelDevolucao;
    }

    public void setResponsavelDevolucao(String responsavelDevolucao) {
        this.responsavelDevolucao = responsavelDevolucao;
    }
}