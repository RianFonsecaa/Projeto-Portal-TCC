package com.ifba.Gerenciador_TCC.documento.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifba.Gerenciador_TCC.documento.domain.enums.TipoDocumentoEnum;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoDTO {
    private UUID id;
    private String titulo;
    private TipoDocumentoEnum tipoDocumento;
    private String caminhoArquivo;

    @JsonIgnore
    private MultipartFile arquivo; 

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }

    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataUpload;

    private Double tamanho;
}
