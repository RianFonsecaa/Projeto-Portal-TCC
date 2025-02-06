package com.ifba.Gerenciador_TCC.tipocurso.mapper;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TipoCursoMapper {

    public abstract TipoCurso dtoToTipoCurso(TipoCursoDTO tipoCursoDTO);

    public abstract TipoCursoDTO tipoCursoToDTO(TipoCurso tipoCurso);
}
