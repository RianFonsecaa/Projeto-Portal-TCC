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
                    .projeto(projetoService.findById(tarefaDTO.getProjetoId()))
                    .titulo(tarefaDTO.getTitulo()) // Nome corrigido
                    .descricao(tarefaDTO.getDescricao())
                    .status(StatusTarefa.valueOf(tarefaDTO.getStatus()))
                    .prioridade(Prioridade.valueOf(tarefaDTO.getPrioridade()))
                    .etapa(tarefaDTO.getEtapa()) // Adicionado
                    .classificacao(Classificacao.valueOf(tarefaDTO.getClassificacao()))
                    .ultimaAtualizacaoEm(tarefaDTO.getUltimaAtualizacaoEm()) // Nome corrigido
                    .ultimaAtualizacaoPor(tarefaDTO.getUltimaAtualizacaoPor()) // Adicionado
                    .criacaoEm(tarefaDTO.getCriacaoEm()) // Adicionado
                    .criacaoPor(tarefaDTO.getCriacaoPor()) // Adicionado
                    .dataInicio(tarefaDTO.getDataInicio()) // Adicionado
                    .dataFim(tarefaDTO.getDataFim()) // Adicionado
                    .build();
    }

    public static TarefaDTO buildTarefaDTO(Tarefa tarefa){
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .projetoId(tarefa.getProjeto().getId())
                .titulo(tarefa.getTitulo()) // Nome corrigido
                .descricao(tarefa.getDescricao())
                .status(tarefa.getStatus().name()) // Convertendo enum para string
                .prioridade(tarefa.getPrioridade().name())
                .etapa(tarefa.getEtapa()) // Adicionado
                .classificacao(tarefa.getClassificacao().name())
                .ultimaAtualizacaoEm(tarefa.getUltimaAtualizacaoEm()) // Nome corrigido
                .ultimaAtualizacaoPor(tarefa.getUltimaAtualizacaoPor()) // Adicionado
                .criacaoEm(tarefa.getCriacaoEm()) // Adicionado
                .criacaoPor(tarefa.getCriacaoPor()) // Adicionado
                .dataInicio(tarefa.getDataInicio()) // Adicionado
                .dataFim(tarefa.getDataFim()) // Adicionado
                .build();
    }
}