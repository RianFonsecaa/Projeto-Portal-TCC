package com.ifba.Gerenciador_TCC.reuniao.mapper;

import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;
import com.ifba.Gerenciador_TCC.reuniao.domain.entity.Reuniao;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T14:46:22-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ReuniaoMapperImpl extends ReuniaoMapper {

    @Override
    public Reuniao dtoToReuniao(ReuniaoDTO reuniaoDTO) {
        if ( reuniaoDTO == null ) {
            return null;
        }

        Reuniao.ReuniaoBuilder reuniao = Reuniao.builder();

        reuniao.dataReuniao( reuniaoDTO.getDataReuniao() );
        reuniao.descricao( reuniaoDTO.getDescricao() );
        reuniao.id( reuniaoDTO.getId() );
        reuniao.idUsuario( reuniaoDTO.getIdUsuario() );
        reuniao.nomeReuniao( reuniaoDTO.getNomeReuniao() );

        return reuniao.build();
    }

    @Override
    public ReuniaoDTO reuniaoToDTO(Reuniao reuniao) {
        if ( reuniao == null ) {
            return null;
        }

        ReuniaoDTO.ReuniaoDTOBuilder reuniaoDTO = ReuniaoDTO.builder();

        reuniaoDTO.dataReuniao( reuniao.getDataReuniao() );
        reuniaoDTO.descricao( reuniao.getDescricao() );
        reuniaoDTO.id( reuniao.getId() );
        reuniaoDTO.idUsuario( reuniao.getIdUsuario() );
        reuniaoDTO.nomeReuniao( reuniao.getNomeReuniao() );

        return reuniaoDTO.build();
    }
}
