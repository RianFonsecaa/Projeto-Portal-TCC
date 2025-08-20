package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    public abstract Usuario dtoToUsuario(UsuarioDTO usuarioDTO);
    public abstract UsuarioDTO usuarioToDTO(Usuario usuario);
}
