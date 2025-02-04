package com.ifba.Gerenciador_TCC.quadrodemandas.mapper;

import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.entity.QuadroDemandas;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class QuadroDemandasMapper {
    public abstract QuadroDemandas dtoToQuadroDemandas(QuadroDemandasDTO quadroDemandasDTO);
    public abstract QuadroDemandasDTO quadroDemandasToDTO(QuadroDemandas quadroDemandas);
}
