package com.ifba.Gerenciador_TCC.projeto.builder;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.InfoProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;

public class InfoProjetoDTOBuilder {
        public static InfoProjetoDTO buildInfoProjetoDTO(Projeto projeto, TarefaService tarefaService){
        return InfoProjetoDTO
                .builder()
                .id(projeto.getId())
                .horasOrientacao(projeto.getHorasOrientacao())
                .progresso(projeto.getProgresso())
                .tipoProjeto(projeto.getTipoProjeto())
                .cursoAutor(projeto.getTipoCurso())
                .titulo(projeto.getTituloProjeto())
                .nomeAutor(projeto.getOrientandoId().getNome())
                .urlImagemCard(projeto.getUrlImagemCard())
                .tarefasAtribuidas(tarefaService.listarTarefasPorProjeto(projeto.getId()).size())
                .tarefasBacklog(tarefaService.listarTarefaPorStatus(StatusTarefa.BACKLOG).size())
                .tarefasPendentes(tarefaService.listarTarefaPorStatus(StatusTarefa.PENDENTE).size())
                .tarefasAndamento(tarefaService.listarTarefaPorStatus(StatusTarefa.ANDAMENTO).size())
                .tarefasConcluidas(tarefaService.listarTarefaPorStatus(StatusTarefa.CONCLUIDA).size())
                .build();
    }
}
