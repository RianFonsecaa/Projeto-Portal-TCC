package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.projeto.service.ProjetoServiceImpl;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;
import com.ifba.Gerenciador_TCC.usuario.mapper.UsuarioMapper;
import com.ifba.Gerenciador_TCC.usuario.repository.UsuarioRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

public class AtribuirTarefaDTOBuilder {
    public static Tarefa buildTarefa(AtribuirTarefaDTO atribuirTarefaDTO, UsuarioServiceApi usuarioService, ProjetoService projetoService) {
        return Tarefa.builder()
                    .projeto(projetoService.findById(atribuirTarefaDTO.getProjetoId()))
                    .orientadorId(usuarioService.findById(atribuirTarefaDTO.getOrientadorId()))
                    .orientandoId(usuarioService.findById(atribuirTarefaDTO.getOrientandoId()))
                    .nomeTarefa(atribuirTarefaDTO.getNomeTarefa())
                    .descricao(atribuirTarefaDTO.getDescricao())
                    .dataEnvio(atribuirTarefaDTO.getDataEnvio())
                    .status(atribuirTarefaDTO.getStatus())
                    .prioridade(atribuirTarefaDTO.getPrioridade())
                    .classificacao(atribuirTarefaDTO.getClassificacao())
                    .prazo(atribuirTarefaDTO.getPrazo())
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
                .projetoId(tarefa.getProjeto().getId())
                .status(tarefa.getStatus())
                .prioridade(tarefa.getPrioridade())
                .classificacao(tarefa.getClassificacao())
                .prazo(tarefa.getPrazo())
                .build();
    }
}
