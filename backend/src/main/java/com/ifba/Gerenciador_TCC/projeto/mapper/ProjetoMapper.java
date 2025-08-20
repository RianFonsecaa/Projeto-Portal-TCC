package com.ifba.Gerenciador_TCC.projeto.mapper;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProjetoMapper {

    public abstract Projeto dtoToProjeto(ProjetoDTO projetoDTO);

    public abstract ProjetoDTO projetoToDTO(Projeto projeto);
}
