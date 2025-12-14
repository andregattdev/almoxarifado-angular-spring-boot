package com.api.almoxarifado.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ferramentas")
public class Ferramenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    private String localizacao;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
    
    // Getters e Setters permanecem os mesmos
    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public String getLocalizacao() {
        return localizacao;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
