package com.ifba.Gerenciador_TCC.tarefa.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Classificacao {
    BIBLIOGRAFIA,
    REDACAO,
    DESENVOLVIMENTO,
    MANUTENCAO,
    PESQUISA,
    ESTUDO,
    PLANEJAMENTO,
    REVISAO,
    DOCUMENTACAO,
    APRESENTACAO;

    @JsonCreator
    public static Classificacao fromString(String value) {
        switch (value.toUpperCase()) {
            case "BIBLIOGRAFIA": return BIBLIOGRAFIA;
            case "REDAÇÃO": return REDACAO;
            case "DESENVOLVIMENTO": return DESENVOLVIMENTO;
            case "MANUTENÇÃO": return MANUTENCAO;
            case "PESQUISA": return PESQUISA;
            case "ESTUDO": return ESTUDO;
            case "PLANEJAMENTO": return PLANEJAMENTO;
            case "REVISÃO": return REVISAO;
            case "DOCUMENTAÇÃO": return DOCUMENTACAO;
            case "APRESENTAÇÃO": return APRESENTACAO;
            default: throw new IllegalArgumentException("Valor inválido para Classificacao: " + value);
        }
    }
}