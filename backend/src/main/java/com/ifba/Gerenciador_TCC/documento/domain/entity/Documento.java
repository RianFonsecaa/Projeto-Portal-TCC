
package com.ifba.Gerenciador_TCC.documento.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O ID do projeto não pode ser vazio")
    @Column(name = "id_projeto", nullable = false)
    private Long idProjeto;

    @NotEmpty(message = "O nome do documento não pode estar vazio")
    @Column(name = "nome_documento", nullable = false, length = 200)
    private String nomeDocumento;

    @NotEmpty(message = "O tipo do documento não pode estar vazio")
    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "A data de envio não pode ser vazia")
    @Column(name = "data_envio", nullable = false)
    private LocalDate dataEnvio;

    @NotNull(message = "A URL do arquivo não pode ser vazia")
    @Column(name = "url_arquivo", nullable = false)
    private String urlArquivo;
}
