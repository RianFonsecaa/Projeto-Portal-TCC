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
    date = "2025-02-07T14:35:04-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
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
        usuario.tipoUsuario( tipoUsuarioDTOToTipoUsuario( usuarioDTO.getTipoUsuario() ) );
        usuario.tipoCurso( tipoCursoDTOToTipoCurso( usuarioDTO.getTipoCurso() ) );

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
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.tipoUsuario( tipoUsuarioToTipoUsuarioDTO( usuario.getTipoUsuario() ) );
        usuarioDTO.tipoCurso( tipoCursoToTipoCursoDTO( usuario.getTipoCurso() ) );

        return usuarioDTO.build();
    }

    protected TipoUsuario tipoUsuarioDTOToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        if ( tipoUsuarioDTO == null ) {
            return null;
        }

        TipoUsuario.TipoUsuarioBuilder tipoUsuario = TipoUsuario.builder();

        if ( tipoUsuarioDTO.getId() != null ) {
            tipoUsuario.id( tipoUsuarioDTO.getId() );
        }
        tipoUsuario.descricaoTipoUsuario( tipoUsuarioDTO.getDescricaoTipoUsuario() );

        return tipoUsuario.build();
    }

    protected TipoCurso tipoCursoDTOToTipoCurso(TipoCursoDTO tipoCursoDTO) {
        if ( tipoCursoDTO == null ) {
            return null;
        }

        TipoCurso.TipoCursoBuilder tipoCurso = TipoCurso.builder();

        if ( tipoCursoDTO.getId() != null ) {
            tipoCurso.id( tipoCursoDTO.getId() );
        }
        tipoCurso.descricaoTipoCurso( tipoCursoDTO.getDescricaoTipoCurso() );

        return tipoCurso.build();
    }

    protected TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        TipoUsuarioDTO.TipoUsuarioDTOBuilder tipoUsuarioDTO = TipoUsuarioDTO.builder();

        tipoUsuarioDTO.id( tipoUsuario.getId() );
        tipoUsuarioDTO.descricaoTipoUsuario( tipoUsuario.getDescricaoTipoUsuario() );

        return tipoUsuarioDTO.build();
    }

    protected TipoCursoDTO tipoCursoToTipoCursoDTO(TipoCurso tipoCurso) {
        if ( tipoCurso == null ) {
            return null;
        }

        TipoCursoDTO.TipoCursoDTOBuilder tipoCursoDTO = TipoCursoDTO.builder();

        tipoCursoDTO.id( tipoCurso.getId() );
        tipoCursoDTO.descricaoTipoCurso( tipoCurso.getDescricaoTipoCurso() );

        return tipoCursoDTO.build();
    }
}
