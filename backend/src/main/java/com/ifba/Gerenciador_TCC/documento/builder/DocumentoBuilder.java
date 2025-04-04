package com.ifba.Gerenciador_TCC.documento.builder;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;

public class DocumentoBuilder {

    public static DocumentoDTO toDTO(DocumentoEntity entity) {
        return DocumentoDTO.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .tipoDocumento(entity.getTipoDocumento())
                .caminhoArquivo(entity.getCaminhoArquivo())
                .build();
    }

    public static DocumentoEntity toEntity(DocumentoDTO dto) {
        return DocumentoEntity.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .tipoDocumento(dto.getTipoDocumento())
                .caminhoArquivo(dto.getCaminhoArquivo())
                .build();
    }
}
