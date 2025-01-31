package com.ifba.Gerenciador_TCC.tcc.domain.dto;

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
public class TccDTO {

    private Long id;

    @NotEmpty(message = "O título do TCC não pode estar vazio")
    private String titulo;

    @NotEmpty(message = "A descrição do TCC não pode estar vazia")
    private String descricao;

    @NotNull(message = "A data de início não pode estar vazia")
    private LocalDate dataInicio;

    @NotNull(message = "A data de entrega não pode estar vazia")
    private LocalDate dataEntrega;

    @NotNull(message = "O status do TCC é obrigatório")
    private Boolean status;


    @NotNull(message = "O ID do aluno não pode ser vazio")
    private Long idAluno;

    @NotNull(message = "O ID do professor orientador não pode ser vazio")
    private Long idOrientador;
}
