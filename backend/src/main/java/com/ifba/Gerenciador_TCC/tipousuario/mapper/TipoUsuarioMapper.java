package com.ifba.Gerenciador_TCC.tipousuario.mapper;

import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TipoUsuarioMapper {

    public abstract TipoUsuario dtoToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);

    public abstract TipoUsuarioDTO tipoUsuarioToDTO(TipoUsuario tipoUsuario);
}