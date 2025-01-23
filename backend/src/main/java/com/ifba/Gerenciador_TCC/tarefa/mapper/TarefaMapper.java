package com.ifba.Gerenciador_TCC.tarefa.mapper;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TarefaMapper {

    public abstract Tarefa dtoToTarefa(TarefaDTO tarefaDTO);

    public abstract TarefaDTO tarefaToDTO(Tarefa tarefa);
}
