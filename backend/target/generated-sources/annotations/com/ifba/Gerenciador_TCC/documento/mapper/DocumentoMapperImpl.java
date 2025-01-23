package com.ifba.Gerenciador_TCC.documento.mapper;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T19:55:32-0300",
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

        documento.dataEnvio( documentoDTO.getDataEnvio() );
        documento.descricao( documentoDTO.getDescricao() );
        documento.id( documentoDTO.getId() );
        documento.idProjeto( documentoDTO.getIdProjeto() );
        documento.nomeDocumento( documentoDTO.getNomeDocumento() );
        documento.tipoDocumento( documentoDTO.getTipoDocumento() );
        documento.urlArquivo( documentoDTO.getUrlArquivo() );

        return documento.build();
    }

    @Override
    public DocumentoDTO documentoToDTO(Documento documento) {
        if ( documento == null ) {
            return null;
        }

        DocumentoDTO.DocumentoDTOBuilder documentoDTO = DocumentoDTO.builder();

        documentoDTO.dataEnvio( documento.getDataEnvio() );
        documentoDTO.descricao( documento.getDescricao() );
        documentoDTO.id( documento.getId() );
        documentoDTO.idProjeto( documento.getIdProjeto() );
        documentoDTO.nomeDocumento( documento.getNomeDocumento() );
        documentoDTO.tipoDocumento( documento.getTipoDocumento() );
        documentoDTO.urlArquivo( documento.getUrlArquivo() );

        return documentoDTO.build();
    }
}
