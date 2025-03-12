package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;

public class TarefaDTOBuilder {
    public static Tarefa buildTarefa(TarefaDTO tarefaDTO, UsuarioServiceApi usuarioService, ProjetoService projetoService) {
        return Tarefa.builder()
                    .projeto(projetoService.findById(tarefaDTO.getProjetoId()))
                    .nomeTarefa(tarefaDTO.getNomeTarefa())
                    .descricao(tarefaDTO.getDescricao())
                    .status(tarefaDTO.getStatus())
                    .prioridade(tarefaDTO.getPrioridade())
                    .classificacao(tarefaDTO.getClassificacao())
                    .prazo(tarefaDTO.getPrazo())
                    .build();
    }

    public static TarefaDTO buildTarefaDTO(Tarefa tarefa){
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .nomeTarefa(tarefa.getNomeTarefa())
                .descricao(tarefa.getDescricao())
                .projetoId(tarefa.getProjeto().getId())
                .status(tarefa.getStatus())
                .prioridade(tarefa.getPrioridade())
                .classificacao(tarefa.getClassificacao())
                .prazo(tarefa.getPrazo())
                .build();
    }
}
