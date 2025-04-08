package com.ifba.Gerenciador_TCC.documento.domain.entity;

import com.ifba.Gerenciador_TCC.documento.domain.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "documento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumentoEnum tipoDocumento;

    @Column(name = "caminho_arquivo")
    private String caminhoArquivo;

    @CreationTimestamp
    @Column(name = "data_upload", updatable = false, nullable = false)
    private LocalDateTime dataUpload;

    @Column(name = "tamanho")
    private Double tamanho;

}
