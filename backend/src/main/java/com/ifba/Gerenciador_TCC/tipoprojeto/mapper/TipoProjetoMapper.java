package com.ifba.Gerenciador_TCC.tipoprojeto.mapper;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;
import com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity.TipoProjeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TipoProjetoMapper {

    public abstract TipoProjeto dtoToTipoProjeto(TipoProjetoDTO tipoProjetoDTO);

    public abstract TipoProjetoDTO tipoProjetoToDTO(TipoProjeto tipoProjeto);
}
