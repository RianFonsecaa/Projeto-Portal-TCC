package com.ifba.Gerenciador_TCC.quadrodemandas.builder;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;

public class QuadroDemandasDTOBuilder {
    public static QuadroDemandasDTO buildQuadroDemandas(Projeto projeto, TarefaService tarefaService){
        return QuadroDemandasDTO
                .builder()
                .id(projeto.getId())
                .horasOrientacao(projeto.getHorasOrientacao())
                .progresso(projeto.getProgresso())
                .tipoProjeto(projeto.getTipoProjeto())
                .cursoAutor(projeto.getTipoCurso())
                .titulo(projeto.getTituloProjeto())
                .nomeAutor(projeto.getOrientandoId().getNome())
                .demandasAtribuidas(tarefaService.listarTarefasPorOrientando(projeto.getOrientandoId().getId()).size())
                .demandasEmAndamento(tarefaService.listarTarefaPorStatus(StatusTarefa.ANDAMENTO).size())
                .demandasResolvidas(tarefaService.listarTarefaPorStatus(StatusTarefa.CONCLUIDA).size())
                .build();
    }
}
