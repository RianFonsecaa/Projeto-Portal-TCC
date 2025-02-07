package com.ifba.Gerenciador_TCC.usuario.mapper;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;
import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-06T23:01:11-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
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
        usuario.tipoCurso( tipoCursoDTOToTipoCurso( usuarioDTO.getTipoCurso() ) );
        usuario.tipoUsuario( tipoUsuarioDTOToTipoUsuario( usuarioDTO.getTipoUsuario() ) );
        usuario.username( usuarioDTO.getUsername() );

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
        usuarioDTO.tipoCurso( tipoCursoToTipoCursoDTO( usuario.getTipoCurso() ) );
        usuarioDTO.tipoUsuario( tipoUsuarioToTipoUsuarioDTO( usuario.getTipoUsuario() ) );
        usuarioDTO.username( usuario.getUsername() );

        return usuarioDTO.build();
    }

    protected TipoCurso tipoCursoDTOToTipoCurso(TipoCursoDTO tipoCursoDTO) {
        if ( tipoCursoDTO == null ) {
            return null;
        }

        TipoCurso.TipoCursoBuilder tipoCurso = TipoCurso.builder();

        tipoCurso.descricaoTipoCurso( tipoCursoDTO.getDescricaoTipoCurso() );
        if ( tipoCursoDTO.getId() != null ) {
            tipoCurso.id( tipoCursoDTO.getId() );
        }

        return tipoCurso.build();
    }

    protected TipoUsuario tipoUsuarioDTOToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        if ( tipoUsuarioDTO == null ) {
            return null;
        }

        TipoUsuario.TipoUsuarioBuilder tipoUsuario = TipoUsuario.builder();

        tipoUsuario.descricaoTipoUsuario( tipoUsuarioDTO.getDescricaoTipoUsuario() );
        if ( tipoUsuarioDTO.getId() != null ) {
            tipoUsuario.id( tipoUsuarioDTO.getId() );
        }

        return tipoUsuario.build();
    }

    protected TipoCursoDTO tipoCursoToTipoCursoDTO(TipoCurso tipoCurso) {
        if ( tipoCurso == null ) {
            return null;
        }

        TipoCursoDTO.TipoCursoDTOBuilder tipoCursoDTO = TipoCursoDTO.builder();

        tipoCursoDTO.descricaoTipoCurso( tipoCurso.getDescricaoTipoCurso() );
        tipoCursoDTO.id( tipoCurso.getId() );

        return tipoCursoDTO.build();
    }

    protected TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        TipoUsuarioDTO.TipoUsuarioDTOBuilder tipoUsuarioDTO = TipoUsuarioDTO.builder();

        tipoUsuarioDTO.descricaoTipoUsuario( tipoUsuario.getDescricaoTipoUsuario() );
        tipoUsuarioDTO.id( tipoUsuario.getId() );

        return tipoUsuarioDTO.build();
    }
}
