package com.ifba.Gerenciador_TCC.tipoprojeto.mapper;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;
import com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity.TipoProjeto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-07T14:35:04-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class TipoProjetoMapperImpl extends TipoProjetoMapper {

    @Override
    public TipoProjeto dtoToTipoProjeto(TipoProjetoDTO tipoProjetoDTO) {
        if ( tipoProjetoDTO == null ) {
            return null;
        }

        TipoProjeto.TipoProjetoBuilder tipoProjeto = TipoProjeto.builder();

        if ( tipoProjetoDTO.getId() != null ) {
            tipoProjeto.id( tipoProjetoDTO.getId() );
        }
        tipoProjeto.descricaoTipoProjeto( tipoProjetoDTO.getDescricaoTipoProjeto() );

        return tipoProjeto.build();
    }

    @Override
    public TipoProjetoDTO tipoProjetoToDTO(TipoProjeto tipoProjeto) {
        if ( tipoProjeto == null ) {
            return null;
        }

        TipoProjetoDTO.TipoProjetoDTOBuilder tipoProjetoDTO = TipoProjetoDTO.builder();

        tipoProjetoDTO.id( tipoProjeto.getId() );
        tipoProjetoDTO.descricaoTipoProjeto( tipoProjeto.getDescricaoTipoProjeto() );

        return tipoProjetoDTO.build();
    }
}
