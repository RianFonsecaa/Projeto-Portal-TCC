package com.ifba.Gerenciador_TCC.tipousuario.mapper;

import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-06T23:01:11-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class TipoUsuarioMapperImpl extends TipoUsuarioMapper {

    @Override
    public TipoUsuario dtoToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
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

    @Override
    public TipoUsuarioDTO tipoUsuarioToDTO(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        TipoUsuarioDTO.TipoUsuarioDTOBuilder tipoUsuarioDTO = TipoUsuarioDTO.builder();

        tipoUsuarioDTO.descricaoTipoUsuario( tipoUsuario.getDescricaoTipoUsuario() );
        tipoUsuarioDTO.id( tipoUsuario.getId() );

        return tipoUsuarioDTO.build();
    }
}
