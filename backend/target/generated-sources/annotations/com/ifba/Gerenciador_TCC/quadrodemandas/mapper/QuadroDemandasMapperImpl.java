package com.ifba.Gerenciador_TCC.quadrodemandas.mapper;

import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.entity.QuadroDemandas;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T13:16:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class QuadroDemandasMapperImpl extends QuadroDemandasMapper {

    @Override
    public QuadroDemandas dtoToQuadroDemandas(QuadroDemandasDTO quadroDemandasDTO) {
        if ( quadroDemandasDTO == null ) {
            return null;
        }

        QuadroDemandas.QuadroDemandasBuilder quadroDemandas = QuadroDemandas.builder();

        quadroDemandas.id( quadroDemandasDTO.getId() );
        quadroDemandas.demandasAtribuidas( quadroDemandasDTO.getDemandasAtribuidas() );
        quadroDemandas.demandasEmAndamento( quadroDemandasDTO.getDemandasEmAndamento() );
        quadroDemandas.demandasResolvidas( quadroDemandasDTO.getDemandasResolvidas() );

        return quadroDemandas.build();
    }

    @Override
    public QuadroDemandasDTO quadroDemandasToDTO(QuadroDemandas quadroDemandas) {
        if ( quadroDemandas == null ) {
            return null;
        }

        QuadroDemandasDTO.QuadroDemandasDTOBuilder quadroDemandasDTO = QuadroDemandasDTO.builder();

        quadroDemandasDTO.id( quadroDemandas.getId() );
        quadroDemandasDTO.demandasAtribuidas( quadroDemandas.getDemandasAtribuidas() );
        quadroDemandasDTO.demandasEmAndamento( quadroDemandas.getDemandasEmAndamento() );
        quadroDemandasDTO.demandasResolvidas( quadroDemandas.getDemandasResolvidas() );

        return quadroDemandasDTO.build();
    }
}
