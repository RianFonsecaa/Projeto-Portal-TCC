package com.ifba.Gerenciador_TCC.reuniao.mapper;

import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;
import com.ifba.Gerenciador_TCC.reuniao.domain.entity.Reuniao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ReuniaoMapper {

    public abstract Reuniao dtoToReuniao(ReuniaoDTO reuniaoDTO);

    public abstract ReuniaoDTO reuniaoToDTO(Reuniao reuniao);
}
