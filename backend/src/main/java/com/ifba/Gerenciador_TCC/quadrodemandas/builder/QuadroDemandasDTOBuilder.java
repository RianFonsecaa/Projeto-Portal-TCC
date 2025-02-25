package com.ifba.Gerenciador_TCC.quadrodemandas.builder;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;

public class QuadroDemandasDTOBuilder {
    public static QuadroDemandasDTO buildQuadroDemandas(Projeto projeto){
        return QuadroDemandasDTO
                .builder()
                .id(projeto.getId())
                .horasOrientacao(projeto.getHorasOrientacao())
                .progresso(projeto.getProgresso())
                .tipoProjeto(projeto.getTipoProjeto())
                .cursoAutor(projeto.getTipoCurso())
                .titulo(projeto.getTituloProjeto())
                .nomeAutor(projeto.getOrientandoId().getNome())
                .build();
    }
}
