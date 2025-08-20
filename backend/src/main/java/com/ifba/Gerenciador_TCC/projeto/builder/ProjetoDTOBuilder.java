package com.ifba.Gerenciador_TCC.projeto.builder;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;

public class ProjetoDTOBuilder {
    public static ProjetoDTO buildProjetoDTO(Projeto projeto){
        return ProjetoDTO.builder()
                .idOrientador(projeto.getOrientadorId().getId())
                .idOrientando(projeto.getOrientandoId().getId())
                .dataCadastro(projeto.getDataCadastro())
                .dataUltimaAlteracao(projeto.getDataUltimaAtualizacao())
                .descricaoProjeto(projeto.getDescricaoProjeto())
                .tituloProjeto(projeto.getTituloProjeto())
                .progresso(projeto.getProgresso())
                .tipoProjeto(projeto.getTipoProjeto())
                .tipoCurso(projeto.getTipoCurso())
                .id(projeto.getId())
                .horasOrientacao(projeto.getHorasOrientacao())
                .build();
    }
}
