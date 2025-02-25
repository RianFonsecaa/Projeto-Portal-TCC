package com.ifba.Gerenciador_TCC.usuario.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "orientador")
public class Orientador extends Usuario {
    @Column(name = "area_pesquisa", nullable = false)
    @NotEmpty(message = "O campo 'areaPesquisa' não pode estar vazio.")
    private String areaPesquisa;

    @Column(name = "cargo", nullable = false)
    @NotEmpty(message = "O campo 'cargo' não pode estar vazio.")
    private String cargo;

    @Column(name = "orientador_disponivel", nullable = false)
    @NotEmpty(message = "O campo 'orientadorDisponivel' não pode estar vazio.")
    private boolean orientadorDisponivel;

    @Column(name = "projetos_em_orientacao", nullable = false)
    @NotEmpty(message = "O campo 'projetosEmOrientacao' não pode estar vazio.")
    private Long projetosEmOrientacao;

    @Column(name = "resumo", nullable = false)
    @NotEmpty(message = "O campo 'projetosEmOrientacao' não pode estar vazio.")
    private String resumo;
}
