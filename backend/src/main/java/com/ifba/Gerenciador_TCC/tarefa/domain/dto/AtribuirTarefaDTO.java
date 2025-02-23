package com.ifba.Gerenciador_TCC.tarefa.domain.dto;

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
public class AtribuirTarefaDTO {

    @NotEmpty(message = "O orientador deve ser informado")
    private long orientadorId;

    @NotEmpty(message = "O orientando deve ser informado")
    private long orientandoId;

    @NotEmpty(message = "O nome da tarefa não pode estar vazio")
    private String nomeTarefa;

    @NotEmpty(message = "A descrição da tarefa não pode estar vazia")
    private String descricao;

    @NotNull(message = "A data de envio não pode ser vazia")
    private LocalDate dataEnvio;

    private LocalDate prazo;
}
