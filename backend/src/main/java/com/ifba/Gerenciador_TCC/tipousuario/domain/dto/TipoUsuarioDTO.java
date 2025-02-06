package com.ifba.Gerenciador_TCC.tipousuario.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoUsuarioDTO {

    private Long id;

    @NotEmpty(message = "A descrição do usuario não pode estar vazia")
    private String descricao;
}
