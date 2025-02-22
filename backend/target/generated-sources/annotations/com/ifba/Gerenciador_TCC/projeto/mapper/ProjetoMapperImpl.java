package com.ifba.Gerenciador_TCC.projeto.mapper;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T14:34:51-0300",
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

        projeto.dataCadastro( projetoDTO.getDataCadastro() );
        projeto.descricaoProjeto( projetoDTO.getDescricaoProjeto() );
        projeto.id( projetoDTO.getId() );
        projeto.tituloProjeto( projetoDTO.getTituloProjeto() );

        return projeto.build();
    }

    @Override
    public ProjetoDTO projetoToDTO(Projeto projeto) {
        if ( projeto == null ) {
            return null;
        }

        ProjetoDTO.ProjetoDTOBuilder projetoDTO = ProjetoDTO.builder();

        projetoDTO.dataCadastro( projeto.getDataCadastro() );
        projetoDTO.descricaoProjeto( projeto.getDescricaoProjeto() );
        projetoDTO.id( projeto.getId() );
        projetoDTO.tituloProjeto( projeto.getTituloProjeto() );

        return projetoDTO.build();
    }
}
