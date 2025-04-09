package com.ifba.Gerenciador_TCC.documento.domain.dto;

import com.ifba.Gerenciador_TCC.documento.domain.enums.TipoDocumentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class DocumentoTarefaDTO {
    private UUID documentoId;
    private String titulo;
    private TipoDocumentoEnum tipoDocumento;
    private String caminhoArquivo;
    private LocalDateTime dataUpload;
    private Double tamanho;
    private Long tarefaId;

    public DocumentoTarefaDTO(UUID documentoId, String titulo, TipoDocumentoEnum tipoDocumento,
                              String caminhoArquivo, LocalDateTime dataUpload, Double tamanho,
                              Long tarefaId) {
        this.documentoId = documentoId;
        this.titulo = titulo;
        this.tipoDocumento = tipoDocumento;
        this.caminhoArquivo = caminhoArquivo;
        this.dataUpload = dataUpload;
        this.tamanho = tamanho;
        this.tarefaId = tarefaId;
    }
}
