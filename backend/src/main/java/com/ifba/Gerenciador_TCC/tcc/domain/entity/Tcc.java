package com.ifba.Gerenciador_TCC.tcc.domain.entity;

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
@Table(name = "tcc")
public class Tcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O título do TCC não pode estar vazio")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @NotEmpty(message = "A descrição do TCC não pode estar vazia")
    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "A data de início não pode estar vazia")
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @NotNull(message = "A data de entrega não pode estar vazia")
    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @NotNull(message = "O status do TCC é obrigatório")
    @Column(name = "status", nullable = false)
    private Boolean status;

}
