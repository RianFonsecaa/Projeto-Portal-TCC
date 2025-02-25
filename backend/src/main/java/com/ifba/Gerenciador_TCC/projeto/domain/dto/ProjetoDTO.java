package com.ifba.Gerenciador_TCC.projeto.domain.dto;

import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import com.ifba.Gerenciador_TCC.tipoenum.TipoProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjetoDTO {

    private Long id;
    private Long idOrientando;
    private Long idOrientador;
    private String tituloProjeto;
    private String descricaoProjeto;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAlteracao;
    private int horasOrientacao;
    private int progresso;
    private TipoProjeto tipoProjeto;
    private TipoCurso tipoCurso;
}
