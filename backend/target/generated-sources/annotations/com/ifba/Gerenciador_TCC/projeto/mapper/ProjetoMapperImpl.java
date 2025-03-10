package com.ifba.Gerenciador_TCC.projeto.mapper;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T16:25:58-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
=======
    date = "2025-02-28T07:42:47-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
>>>>>>> cf3b292ce74d6bf7858113b254eba405cea99179
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
