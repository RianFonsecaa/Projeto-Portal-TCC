package com.ifba.Gerenciador_TCC.projeto.mapper;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-30T21:34:37-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
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
        projeto.horasOrientacao( projetoDTO.getHorasOrientacao() );
        projeto.id( projetoDTO.getId() );
        projeto.progresso( projetoDTO.getProgresso() );
        projeto.tipoCurso( projetoDTO.getTipoCurso() );
        projeto.tipoProjeto( projetoDTO.getTipoProjeto() );
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
        projetoDTO.horasOrientacao( projeto.getHorasOrientacao() );
        projetoDTO.id( projeto.getId() );
        projetoDTO.progresso( projeto.getProgresso() );
        projetoDTO.tipoCurso( projeto.getTipoCurso() );
        projetoDTO.tipoProjeto( projeto.getTipoProjeto() );
        projetoDTO.tituloProjeto( projeto.getTituloProjeto() );

        return projetoDTO.build();
    }
}
