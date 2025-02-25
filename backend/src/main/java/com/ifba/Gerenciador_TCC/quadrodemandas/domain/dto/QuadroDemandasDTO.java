package com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto;

import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import com.ifba.Gerenciador_TCC.tipoenum.TipoProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuadroDemandasDTO {

    private long id;
    private String titulo;
    private String nomeAutor;
    private TipoCurso cursoAutor;
    private TipoProjeto tipoProjeto;
    private int horasOrientacao;
    private int progresso;

}
