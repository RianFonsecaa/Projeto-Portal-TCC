package com.ifba.Gerenciador_TCC.tarefa.domain.mapper;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-21T21:52:43-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
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
        tarefa.idUsuario( tarefaDTO.getIdUsuario() );
        tarefa.idDocumento( tarefaDTO.getIdDocumento() );
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
        tarefaDTO.idUsuario( tarefa.getIdUsuario() );
        tarefaDTO.idDocumento( tarefa.getIdDocumento() );
        tarefaDTO.nomeTarefa( tarefa.getNomeTarefa() );
        tarefaDTO.descricao( tarefa.getDescricao() );
        tarefaDTO.dataEnvio( tarefa.getDataEnvio() );
        tarefaDTO.dataFim( tarefa.getDataFim() );

        return tarefaDTO.build();
    }
}
