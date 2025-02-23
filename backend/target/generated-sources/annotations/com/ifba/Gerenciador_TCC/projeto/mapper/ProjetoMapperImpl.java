package com.ifba.Gerenciador_TCC.projeto.mapper;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T22:28:56-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
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
