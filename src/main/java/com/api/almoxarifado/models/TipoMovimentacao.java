package com.api.almoxarifado.models;

public enum TipoMovimentacao {
    ENTRADA("Entrada"),
    SAIDA("Saída"),
    DEVOLUCAO("Devolução");

    private final String descricao;

    TipoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEntrada() {
        return this == ENTRADA;
    }

    public boolean isSaida() {
        return this == SAIDA;
    }

    public boolean isDevolucao() {
        return this == DEVOLUCAO;
    }
}

