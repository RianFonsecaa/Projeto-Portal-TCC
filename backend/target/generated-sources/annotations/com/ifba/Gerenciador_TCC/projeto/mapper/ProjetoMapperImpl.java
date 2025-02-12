package com.ifba.Gerenciador_TCC.projeto.mapper;

import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T15:40:33-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ProjetoMapperImpl extends ProjetoMapper {

    @Override
    public Projeto dtoToProjeto(ProjetoDTO projetoDTO) {
        if ( projetoDTO == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.id( projetoDTO.getId() );
        projeto.tituloProjeto( projetoDTO.getTituloProjeto() );
        projeto.descricaoProjeto( projetoDTO.getDescricaoProjeto() );
        projeto.dataCadastro( projetoDTO.getDataCadastro() );

        return projeto.build();
    }

    @Override
    public ProjetoDTO projetoToDTO(Projeto projeto) {
        if ( projeto == null ) {
            return null;
        }

        ProjetoDTO.ProjetoDTOBuilder projetoDTO = ProjetoDTO.builder();

        projetoDTO.id( projeto.getId() );
        projetoDTO.tituloProjeto( projeto.getTituloProjeto() );
        projetoDTO.descricaoProjeto( projeto.getDescricaoProjeto() );
        projetoDTO.dataCadastro( projeto.getDataCadastro() );

        return projetoDTO.build();
    }
}
