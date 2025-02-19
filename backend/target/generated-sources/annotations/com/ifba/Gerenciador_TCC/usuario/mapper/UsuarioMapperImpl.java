package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-19T14:31:16-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
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
        usuario.username( usuarioDTO.getUsername() );
        usuario.senha( usuarioDTO.getSenha() );
        usuario.nome( usuarioDTO.getNome() );
        usuario.email( usuarioDTO.getEmail() );
        usuario.tipoUsuario( usuarioDTO.getTipoUsuario() );
        usuario.tipoCurso( usuarioDTO.getTipoCurso() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO usuarioToDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.id( usuario.getId() );
        usuarioDTO.username( usuario.getUsername() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.tipoUsuario( usuario.getTipoUsuario() );
        usuarioDTO.tipoCurso( usuario.getTipoCurso() );

        return usuarioDTO.build();
    }
}
