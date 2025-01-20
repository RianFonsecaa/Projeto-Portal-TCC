
package com.ifba.Gerenciador_TCC.tarefa.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @NotNull(message = "O ID do usuário não pode estar vazio")
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_documento", nullable = true)
    private Long idDocumento;

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
}
