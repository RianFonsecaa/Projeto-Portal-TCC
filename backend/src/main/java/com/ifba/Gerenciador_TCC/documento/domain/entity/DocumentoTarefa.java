package com.ifba.Gerenciador_TCC.documento.domain.entity;

import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "documentotarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @NotNull(message = "O id da tarefa não pode estar vazio")
    @JoinColumn(name = "tarefa_id", nullable = false)
    private Tarefa tarefa;

    @ManyToOne
    @NotNull(message = "O id do documento não pode estar vazio")
    @JoinColumn(name = "documento_id", nullable = false)
    private DocumentoEntity documento;

}
