package com.ifba.Gerenciador_TCC.documento.mapper;

import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T15:40:21-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class DocumentoMapperImpl extends DocumentoMapper {

    @Override
    public Documento dtoToDocumento(DocumentoDTO documentoDTO) {
        if ( documentoDTO == null ) {
            return null;
        }

        Documento.DocumentoBuilder documento = Documento.builder();

        documento.id( documentoDTO.getId() );
        documento.nomeDocumento( documentoDTO.getNomeDocumento() );
        documento.tipoDocumento( documentoDTO.getTipoDocumento() );
        documento.descricao( documentoDTO.getDescricao() );
        documento.dataEnvio( documentoDTO.getDataEnvio() );
        documento.urlArquivo( documentoDTO.getUrlArquivo() );

        return documento.build();
    }

    @Override
    public DocumentoDTO documentoToDTO(Documento documento) {
        if ( documento == null ) {
            return null;
        }

        DocumentoDTO.DocumentoDTOBuilder documentoDTO = DocumentoDTO.builder();

        documentoDTO.id( documento.getId() );
        documentoDTO.nomeDocumento( documento.getNomeDocumento() );
        documentoDTO.tipoDocumento( documento.getTipoDocumento() );
        documentoDTO.descricao( documento.getDescricao() );
        documentoDTO.dataEnvio( documento.getDataEnvio() );
        documentoDTO.urlArquivo( documento.getUrlArquivo() );

        return documentoDTO.build();
    }
}
