package com.ifba.Gerenciador_TCC.tcc.builder;


import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccCardDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;

public class TccCardDTOBuilder {

    public static TccCardDTO buildTccCardDTO(Tcc tcc, Projeto projeto, QuadroDemandasDTO quadroDemandas) {
        return TccCardDTO.builder()
                .id(tcc.getId())
                .titulo(tcc.getTitulo())
                .username(projeto.getOrientandoId().getUsername())
                .tipoCurso(projeto.getTipoCurso().name())
                .tipoProjeto(projeto.getTipoProjeto().name())
                .horasOrientacao(projeto.getHorasOrientacao())
                .progresso(projeto.getProgresso())
                .demandasAtribuidas(quadroDemandas.getDemandasAtribuidas())
                .demandasEmAndamento(quadroDemandas.getDemandasEmAndamento())
                .demandasResolvidas(quadroDemandas.getDemandasResolvidas())
                .build();
    }
}
