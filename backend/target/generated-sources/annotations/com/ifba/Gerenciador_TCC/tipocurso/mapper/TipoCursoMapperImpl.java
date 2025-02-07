package com.ifba.Gerenciador_TCC.tipocurso.mapper;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-07T14:35:04-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class TipoCursoMapperImpl extends TipoCursoMapper {

    @Override
    public TipoCurso dtoToTipoCurso(TipoCursoDTO tipoCursoDTO) {
        if ( tipoCursoDTO == null ) {
            return null;
        }

        TipoCurso.TipoCursoBuilder tipoCurso = TipoCurso.builder();

        if ( tipoCursoDTO.getId() != null ) {
            tipoCurso.id( tipoCursoDTO.getId() );
        }
        tipoCurso.descricaoTipoCurso( tipoCursoDTO.getDescricaoTipoCurso() );

        return tipoCurso.build();
    }

    @Override
    public TipoCursoDTO tipoCursoToDTO(TipoCurso tipoCurso) {
        if ( tipoCurso == null ) {
            return null;
        }

        TipoCursoDTO.TipoCursoDTOBuilder tipoCursoDTO = TipoCursoDTO.builder();

        tipoCursoDTO.id( tipoCurso.getId() );
        tipoCursoDTO.descricaoTipoCurso( tipoCurso.getDescricaoTipoCurso() );

        return tipoCursoDTO.build();
    }
}
