package com.ifba.Gerenciador_TCC.tarefa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaAgendaDTO {
    private String descricao;
    private LocalDate prazo;
}
