package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T12:07:53-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public Usuario dtoToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.email( usuarioDTO.getEmail() );
        usuario.id( usuarioDTO.getId() );
        usuario.nome( usuarioDTO.getNome() );
        usuario.senha( usuarioDTO.getSenha() );
        usuario.telefone( usuarioDTO.getTelefone() );
        usuario.tipoUsuario( usuarioDTO.getTipoUsuario() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.id( usuario.getId() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.telefone( usuario.getTelefone() );
        usuarioDTO.tipoUsuario( usuario.getTipoUsuario() );

        return usuarioDTO.build();
    }
}
