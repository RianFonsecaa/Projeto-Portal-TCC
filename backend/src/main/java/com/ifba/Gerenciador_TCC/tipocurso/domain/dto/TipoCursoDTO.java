package com.ifba.Gerenciador_TCC.tipocurso.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoCursoDTO {

    private Long id;

    @NotEmpty(message = "A descrição do tipo de curso não pode estar vazia")
    private String descricaoTipoCurso;
}
