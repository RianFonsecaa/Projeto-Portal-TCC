package com.ifba.Gerenciador_TCC.tarefa.builder;

import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Classificacao;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Prioridade;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;

public class TarefaDTOBuilder {
    
    public static Tarefa buildTarefa(TarefaDTO tarefaDTO, UsuarioServiceApi usuarioService, ProjetoService projetoService) {
        return Tarefa.builder()
                    .id(tarefaDTO.getId())
                    .codigo(tarefaDTO.getCodigo())
                    .projeto(projetoService.findById(tarefaDTO.getProjetoId()))
                    .titulo(tarefaDTO.getTitulo()) 
                    .descricao(tarefaDTO.getDescricao())
                    .status(StatusTarefa.valueOf(tarefaDTO.getStatus()))
                    .prioridade(Prioridade.valueOf(tarefaDTO.getPrioridade()))
                    .etapa(tarefaDTO.getEtapa()) 
                    .classificacao(Classificacao.valueOf(tarefaDTO.getClassificacao()))
                    .ultimaAtualizacaoEm(tarefaDTO.getUltimaAtualizacaoEm()) 
                    .ultimaAtualizacaoPor(tarefaDTO.getUltimaAtualizacaoPor()) 
                    .criacaoEm(tarefaDTO.getCriacaoEm()) 
                    .criacaoPor(tarefaDTO.getCriacaoPor())
                    .dataInicio(tarefaDTO.getDataInicio()) 
                    .dataFim(tarefaDTO.getDataFim()) 
                    .build();
    }

    public static TarefaDTO buildTarefaDTO(Tarefa tarefa){
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .codigo(tarefa.getCodigo())
                .projetoId(tarefa.getProjeto().getId())
                .titulo(tarefa.getTitulo())
                .descricao(tarefa.getDescricao())
                .status(tarefa.getStatus().name())
                .prioridade(tarefa.getPrioridade().name())
                .etapa(tarefa.getEtapa()) // Adicionado
                .classificacao(tarefa.getClassificacao().name())
                .ultimaAtualizacaoEm(tarefa.getUltimaAtualizacaoEm())
                .ultimaAtualizacaoPor(tarefa.getUltimaAtualizacaoPor())
                .criacaoEm(tarefa.getCriacaoEm()) 
                .criacaoPor(tarefa.getCriacaoPor())
                .dataInicio(tarefa.getDataInicio())
                .dataFim(tarefa.getDataFim()) 
                .build();
    }
}