package com.ifba.Gerenciador_TCC.documento.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifba.Gerenciador_TCC.documento.domain.enums.TipoDocumentoEnum;
import lombok.*;

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
}
