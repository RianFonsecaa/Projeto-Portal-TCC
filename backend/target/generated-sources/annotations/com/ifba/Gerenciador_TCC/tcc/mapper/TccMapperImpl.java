package com.ifba.Gerenciador_TCC.tcc.mapper;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T22:28:56-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TccMapperImpl implements TccMapper {

    @Override
    public Tcc dtoToTcc(TccDTO tccDTO) {
        if ( tccDTO == null ) {
            return null;
        }

        Tcc.TccBuilder tcc = Tcc.builder();

        tcc.id( tccDTO.getId() );
        tcc.titulo( tccDTO.getTitulo() );
        tcc.descricao( tccDTO.getDescricao() );
        tcc.dataInicio( tccDTO.getDataInicio() );
        tcc.dataEntrega( tccDTO.getDataEntrega() );
        tcc.status( tccDTO.getStatus() );

        return tcc.build();
    }

    @Override
    public TccDTO tccToDto(Tcc tcc) {
        if ( tcc == null ) {
            return null;
        }

        TccDTO.TccDTOBuilder tccDTO = TccDTO.builder();

        tccDTO.id( tcc.getId() );
        tccDTO.titulo( tcc.getTitulo() );
        tccDTO.descricao( tcc.getDescricao() );
        tccDTO.dataInicio( tcc.getDataInicio() );
        tccDTO.dataEntrega( tcc.getDataEntrega() );
        tccDTO.status( tcc.getStatus() );

        return tccDTO.build();
    }
}
