package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;
import com.ifba.Gerenciador_TCC.usuario.mapper.UsuarioMapperImpl;
import com.ifba.Gerenciador_TCC.usuario.repository.UsuarioRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

public class AtribuirTarefaDTOBuilder {
    public static Tarefa buildTarefa(AtribuirTarefaDTO atribuirTarefaDTO, UsuarioServiceApi usuarioService){
        return Tarefa.builder()
                    .orientadorId(usuarioService.findById(atribuirTarefaDTO.getOrientadorId()))
                    .orientandoId(usuarioService.findById(atribuirTarefaDTO.getOrientandoId()))
                    .nomeTarefa(atribuirTarefaDTO.getNomeTarefa())
                    .descricao(atribuirTarefaDTO.getDescricao())
                    .dataEnvio(atribuirTarefaDTO.getDataEnvio())
                    .build();
    }

    public static TarefaDTO buildTarefaDTO(Tarefa tarefa){
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .nomeTarefa(tarefa.getNomeTarefa())
                .dataFim(tarefa.getDataFim())
                .dataEnvio(tarefa.getDataEnvio())
                .descricao(tarefa.getDescricao())
                .orientadorId(tarefa.getOrientadorId().getId())
                .orientandoId(tarefa.getOrientandoId().getId())
                .build();
    }
}
