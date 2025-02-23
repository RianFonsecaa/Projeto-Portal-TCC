
package com.ifba.Gerenciador_TCC.tarefa.domain.entity;

import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;
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
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orientador_id", referencedColumnName = "id", nullable = false, unique = false)
    private Usuario orientadorId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orientando_id", referencedColumnName = "id", nullable = false, unique = false)
    private Usuario orientandoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusTarefa status;

    @OneToMany
    @JoinColumn(name = "documento_id", referencedColumnName = "id", nullable = true)
    private List<Documento> documentoId;

    @NotEmpty(message = "O nome da tarefa não pode estar vazio")
    @Column(name = "nome_tarefa", nullable = false, length = 200)
    private String nomeTarefa;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "A data de envio não pode ser vazia")
    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;

    @Column(name = "data_fim", nullable = true)
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade", nullable = false)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false)
    private Classificacao classificacao;

    @Column(name = "alerta", nullable = false)
    private boolean alerta;

    @Column(name = "prazo", nullable = true)
    private LocalDate prazo;
}
