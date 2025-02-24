package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-24T13:46:58-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public Usuario dtoToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( usuarioDTO.getId() );
        usuario.senha( usuarioDTO.getSenha() );
        usuario.nome( usuarioDTO.getNome() );
        usuario.email( usuarioDTO.getEmail() );
        usuario.tipoUsuario( usuarioDTO.getTipoUsuario() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.id( usuario.getId() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.tipoUsuario( usuario.getTipoUsuario() );

        return usuarioDTO.build();
    }
}
