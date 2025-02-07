package com.ifba.Gerenciador_TCC.tipocurso.mapper;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-06T23:01:12-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TipoCursoMapperImpl extends TipoCursoMapper {

    @Override
    public TipoCurso dtoToTipoCurso(TipoCursoDTO tipoCursoDTO) {
        if ( tipoCursoDTO == null ) {
            return null;
        }

        TipoCurso.TipoCursoBuilder tipoCurso = TipoCurso.builder();

        tipoCurso.descricaoTipoCurso( tipoCursoDTO.getDescricaoTipoCurso() );
        if ( tipoCursoDTO.getId() != null ) {
            tipoCurso.id( tipoCursoDTO.getId() );
        }

        return tipoCurso.build();
    }

    @Override
    public TipoCursoDTO tipoCursoToDTO(TipoCurso tipoCurso) {
        if ( tipoCurso == null ) {
            return null;
        }

        TipoCursoDTO.TipoCursoDTOBuilder tipoCursoDTO = TipoCursoDTO.builder();

        tipoCursoDTO.descricaoTipoCurso( tipoCurso.getDescricaoTipoCurso() );
        tipoCursoDTO.id( tipoCurso.getId() );

        return tipoCursoDTO.build();
    }
}
