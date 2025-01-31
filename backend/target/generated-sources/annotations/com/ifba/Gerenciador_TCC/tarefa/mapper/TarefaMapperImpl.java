package com.ifba.Gerenciador_TCC.tarefa.mapper;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-31T15:37:13-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TarefaMapperImpl extends TarefaMapper {

    @Override
    public Tarefa dtoToTarefa(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Tarefa.TarefaBuilder tarefa = Tarefa.builder();

        tarefa.id( tarefaDTO.getId() );
        tarefa.nomeTarefa( tarefaDTO.getNomeTarefa() );
        tarefa.descricao( tarefaDTO.getDescricao() );
        tarefa.dataEnvio( tarefaDTO.getDataEnvio() );
        tarefa.dataFim( tarefaDTO.getDataFim() );

        return tarefa.build();
    }

    @Override
    public TarefaDTO tarefaToDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaDTO.TarefaDTOBuilder tarefaDTO = TarefaDTO.builder();

        tarefaDTO.id( tarefa.getId() );
        tarefaDTO.nomeTarefa( tarefa.getNomeTarefa() );
        tarefaDTO.descricao( tarefa.getDescricao() );
        tarefaDTO.dataEnvio( tarefa.getDataEnvio() );
        tarefaDTO.dataFim( tarefa.getDataFim() );

        return tarefaDTO.build();
    }
}
