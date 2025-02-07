package com.ifba.Gerenciador_TCC.tarefa.mapper;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-07T16:00:57-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TarefaMapperImpl extends TarefaMapper {

    @Override
    public Tarefa dtoToTarefa(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Tarefa.TarefaBuilder tarefa = Tarefa.builder();

        tarefa.dataEnvio( tarefaDTO.getDataEnvio() );
        tarefa.dataFim( tarefaDTO.getDataFim() );
        tarefa.descricao( tarefaDTO.getDescricao() );
        tarefa.id( tarefaDTO.getId() );
        tarefa.nomeTarefa( tarefaDTO.getNomeTarefa() );

        return tarefa.build();
    }

    @Override
    public TarefaDTO tarefaToDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaDTO.TarefaDTOBuilder tarefaDTO = TarefaDTO.builder();

        tarefaDTO.dataEnvio( tarefa.getDataEnvio() );
        tarefaDTO.dataFim( tarefa.getDataFim() );
        tarefaDTO.descricao( tarefa.getDescricao() );
        tarefaDTO.id( tarefa.getId() );
        tarefaDTO.nomeTarefa( tarefa.getNomeTarefa() );

        return tarefaDTO.build();
    }
}
