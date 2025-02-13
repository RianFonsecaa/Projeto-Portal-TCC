package com.ifba.Gerenciador_TCC.tcc.mapper;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-13T15:59:48-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TccMapperImpl implements TccMapper {

    @Override
    public Tcc dtoToTcc(TccDTO tccDTO) {
        if ( tccDTO == null ) {
            return null;
        }

        Tcc.TccBuilder tcc = Tcc.builder();

        tcc.dataEntrega( tccDTO.getDataEntrega() );
        tcc.dataInicio( tccDTO.getDataInicio() );
        tcc.descricao( tccDTO.getDescricao() );
        tcc.id( tccDTO.getId() );
        tcc.status( tccDTO.getStatus() );
        tcc.titulo( tccDTO.getTitulo() );

        return tcc.build();
    }

    @Override
    public TccDTO tccToDto(Tcc tcc) {
        if ( tcc == null ) {
            return null;
        }

        TccDTO.TccDTOBuilder tccDTO = TccDTO.builder();

        tccDTO.dataEntrega( tcc.getDataEntrega() );
        tccDTO.dataInicio( tcc.getDataInicio() );
        tccDTO.descricao( tcc.getDescricao() );
        tccDTO.id( tcc.getId() );
        tccDTO.status( tcc.getStatus() );
        tccDTO.titulo( tcc.getTitulo() );

        return tccDTO.build();
    }
}
