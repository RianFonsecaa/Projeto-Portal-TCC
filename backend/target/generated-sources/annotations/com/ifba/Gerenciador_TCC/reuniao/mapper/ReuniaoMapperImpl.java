package com.ifba.Gerenciador_TCC.reuniao.mapper;

import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;
import com.ifba.Gerenciador_TCC.reuniao.domain.entity.Reuniao;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T15:40:21-0300",
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

        reuniao.id( reuniaoDTO.getId() );
        reuniao.idUsuario( reuniaoDTO.getIdUsuario() );
        reuniao.nomeReuniao( reuniaoDTO.getNomeReuniao() );
        reuniao.descricao( reuniaoDTO.getDescricao() );
        reuniao.dataReuniao( reuniaoDTO.getDataReuniao() );

        return reuniao.build();
    }

    @Override
    public ReuniaoDTO reuniaoToDTO(Reuniao reuniao) {
        if ( reuniao == null ) {
            return null;
        }

        ReuniaoDTO.ReuniaoDTOBuilder reuniaoDTO = ReuniaoDTO.builder();

        reuniaoDTO.id( reuniao.getId() );
        reuniaoDTO.idUsuario( reuniao.getIdUsuario() );
        reuniaoDTO.nomeReuniao( reuniao.getNomeReuniao() );
        reuniaoDTO.descricao( reuniao.getDescricao() );
        reuniaoDTO.dataReuniao( reuniao.getDataReuniao() );

        return reuniaoDTO.build();
    }
}
