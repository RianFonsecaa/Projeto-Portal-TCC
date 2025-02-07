package com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoProjetoDTO {

    private Long id;

    @NotEmpty(message = "A descrição do tipo de projeto não pode estar vazia")
    private String descricaoTipoProjeto;
}
