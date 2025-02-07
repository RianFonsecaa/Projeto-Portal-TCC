package com.ifba.Gerenciador_TCC.tipousuario.mapper;

import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-07T14:35:04-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class TipoUsuarioMapperImpl extends TipoUsuarioMapper {

    @Override
    public TipoUsuario dtoToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
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

    @Override
    public TipoUsuarioDTO tipoUsuarioToDTO(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        TipoUsuarioDTO.TipoUsuarioDTOBuilder tipoUsuarioDTO = TipoUsuarioDTO.builder();

        tipoUsuarioDTO.id( tipoUsuario.getId() );
        tipoUsuarioDTO.descricaoTipoUsuario( tipoUsuario.getDescricaoTipoUsuario() );

        return tipoUsuarioDTO.build();
    }
}
