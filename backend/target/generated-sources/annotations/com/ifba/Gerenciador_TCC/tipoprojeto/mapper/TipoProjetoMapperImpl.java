package com.ifba.Gerenciador_TCC.tipoprojeto.mapper;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;
import com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity.TipoProjeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-06T18:46:28-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TipoProjetoMapperImpl extends TipoProjetoMapper {

    @Override
    public TipoProjeto dtoToTipoProjeto(TipoProjetoDTO tipoProjetoDTO) {
        if ( tipoProjetoDTO == null ) {
            return null;
        }

        TipoProjeto.TipoProjetoBuilder tipoProjeto = TipoProjeto.builder();

        tipoProjeto.descricao( tipoProjetoDTO.getDescricao() );
        if ( tipoProjetoDTO.getId() != null ) {
            tipoProjeto.id( tipoProjetoDTO.getId() );
        }

        return tipoProjeto.build();
    }

    @Override
    public TipoProjetoDTO tipoProjetoToDTO(TipoProjeto tipoProjeto) {
        if ( tipoProjeto == null ) {
            return null;
        }

        TipoProjetoDTO.TipoProjetoDTOBuilder tipoProjetoDTO = TipoProjetoDTO.builder();

        tipoProjetoDTO.descricao( tipoProjeto.getDescricao() );
        tipoProjetoDTO.id( tipoProjeto.getId() );

        return tipoProjetoDTO.build();
    }
}
