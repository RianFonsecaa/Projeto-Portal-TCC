package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;

public class AtribuirTarefaDTOBuilder {
    public Tarefa buildTarefa(AtribuirTarefaDTO atribuirTarefaDTO){
        return Tarefa.builder()
                    .orientadorId(atribuirTarefaDTO.getOrientadorId())
    }
}
