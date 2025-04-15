package com.ifba.Gerenciador_TCC.agenda.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
public class TarefaAgendaDTO {
    private String descricao;
    private LocalDate dataFim;

    public TarefaAgendaDTO(String descricao, LocalDate dataFim) {
        this.descricao = descricao;
        this.dataFim = dataFim;
    }
}
