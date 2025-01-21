package com.ifba.Gerenciador_TCC.tcc.mapper;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TccMapper {

    Tcc dtoToTcc(TccDTO tccDTO);

    TccDTO tccToDto(Tcc tcc);
}
