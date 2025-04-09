package com.ifba.Gerenciador_TCC.documento.domain.entity;

import com.ifba.Gerenciador_TCC.documento.domain.enums.EscopoDocumentoEnum;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "escopo_documento",nullable = false)
    private EscopoDocumentoEnum escopoDocumento;

    @Column(name = "caminho_arquivo")
    private String caminhoArquivo;

    @CreationTimestamp
    @Column(name = "data_upload", updatable = false, nullable = false)
    private LocalDateTime dataUpload;

    @Column(name = "tamanho")
    private Double tamanho;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @ManyToOne
    @NotNull(message = "O id do projeto não pode estar vazio")
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

}
