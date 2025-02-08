package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.usuario.mapper.UsuarioMapperImpl;
import com.ifba.Gerenciador_TCC.usuario.repository.UsuarioRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

public class AtribuirTarefaDTOBuilder {
    private final UsuarioService usuarioService = new UsuarioService();
    public Tarefa buildTarefa(AtribuirTarefaDTO atribuirTarefaDTO){
        return Tarefa.builder()
                    .orientadorId(usuarioService.findById(atribuirTarefaDTO.getOrientadorId()))
                    .orientandoId(usuarioService.findById(atribuirTarefaDTO.getOrientandoId()))
                    .nomeTarefa(atribuirTarefaDTO.getNomeTarefa())
                    .descricao(atribuirTarefaDTO.getDescricao())
                    .dataEnvio(atribuirTarefaDTO.getDataEnvio())
                    .build();
    }
}
