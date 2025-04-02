
package com.ifba.Gerenciador_TCC.tarefa.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Classificacao;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Prioridade;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

    @NotEmpty(message = "O título da tarefa não pode estar vazio")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusTarefa status;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade", nullable = false)
    private Prioridade prioridade;

    @Column(name = "etapa", nullable = false)
    private String etapa;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false)
    private Classificacao classificacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ultima_atualizacao_em", nullable = false)
    private LocalDateTime ultimaAtualizacaoEm;

    @Column(name = "ultima_atualizacao_por", nullable = false)
    private String ultimaAtualizacaoPor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "criacao_em", nullable = false, updatable = false)
    private LocalDateTime criacaoEm;

    @Column(name = "criacao_por", nullable = false, updatable = false)
    private String criacaoPor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

   
}