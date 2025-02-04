package com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuadroDemandasDTO {
    private Long id;
    private int demandasAtribuidas;
    private int demandasEmAndamento;
    private int demandasResolvidas;
}
