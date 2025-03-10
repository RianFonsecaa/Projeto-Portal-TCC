package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T16:25:58-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
=======
    date = "2025-02-28T07:42:47-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
>>>>>>> cf3b292ce74d6bf7858113b254eba405cea99179
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
        usuarioDTO.tipoUsuario( usuario.getTipoUsuario() );

        return usuarioDTO.build();
    }
}
