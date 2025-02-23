package com.ifba.Gerenciador_TCC.tcc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TccCardDTO {
    private Long id;  // ID do TCC 
    private String titulo;  // Do Tcc
    private String username;  // Do Usuario
    private String tipoCurso;  // Do TipoCurso
    private String tipoProjeto;  // Do TipoProjeto
    private int horasOrientacao;  // Do Projeto
    private int progresso;  // Do Projeto
    private int demandasAtribuidas;  // Do Tcc (QuadroDemandas)
    private int demandasEmAndamento;  // Do Tcc (QuadroDemandas)
    private int demandasResolvidas;  // Do Tcc (QuadroDemandas)
}
