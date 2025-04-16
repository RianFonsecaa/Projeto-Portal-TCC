package com.ifba.Gerenciador_TCC.documento.builder;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;

public class DocumentoBuilder {

    public static DocumentoDTO toDTO(DocumentoEntity entity) {
        return DocumentoDTO.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .escopoDocumento(entity.getEscopoDocumento())
                .tipoDocumento(entity.getTipoDocumento())
                .caminhoArquivo(entity.getCaminhoArquivo())
                .dataUpload(entity.getDataUpload())
                .tamanho(entity.getTamanho())
                .projetoId(entity.getProjeto().getId())
                .build();
    }

    public static DocumentoEntity toEntity(DocumentoDTO dto, Projeto projeto) {
        return DocumentoEntity.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .escopoDocumento(dto.getEscopoDocumento())
                .tipoDocumento(dto.getTipoDocumento())
                .caminhoArquivo(dto.getCaminhoArquivo())
                .tamanho(dto.getTamanho())
                .projeto(projeto)
                .build();
    }
}
