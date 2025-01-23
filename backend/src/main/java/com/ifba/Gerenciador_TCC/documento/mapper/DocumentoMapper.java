package com.ifba.Gerenciador_TCC.documento.mapper;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DocumentoMapper {

    public abstract Documento dtoToDocumento(DocumentoDTO documentoDTO);

    public abstract DocumentoDTO documentoToDTO(Documento documento);
}
