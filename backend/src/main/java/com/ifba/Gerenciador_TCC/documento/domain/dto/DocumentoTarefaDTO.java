package com.ifba.Gerenciador_TCC.documento.domain.dto;

import com.ifba.Gerenciador_TCC.documento.domain.enums.EscopoDocumentoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class DocumentoTarefaDTO {
    private UUID documentoId;
    private String titulo;
    private EscopoDocumentoEnum escopoDocumento;
    private String caminhoArquivo;
    private LocalDateTime dataUpload;
    private Double tamanho;
    private String tipoDocumento;
    private Long tarefaId;

    public DocumentoTarefaDTO(UUID documentoId, String titulo, EscopoDocumentoEnum escopoDocumento,
                              String caminhoArquivo, LocalDateTime dataUpload, Double tamanho,
                              String tipoDocumento,Long tarefaId) {
        this.documentoId = documentoId;
        this.titulo = titulo;
        this.escopoDocumento = escopoDocumento;
        this.caminhoArquivo = caminhoArquivo;
        this.dataUpload = dataUpload;
        this.tamanho = tamanho;
        this.tipoDocumento = tipoDocumento;
        this.tarefaId = tarefaId;
    }
}
