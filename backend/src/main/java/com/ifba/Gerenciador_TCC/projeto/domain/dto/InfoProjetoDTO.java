package com.ifba.Gerenciador_TCC.projeto.domain.dto;

import java.time.LocalDate;

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
public class InfoProjetoDTO {
    private long id;
    private String titulo;
    private String nomeAutor;
    private TipoCurso cursoAutor;
    private TipoProjeto tipoProjeto;
    private int horasOrientacao;
    private int progresso;
    private LocalDate dataUltimaAtualizacao;
    private int demandasAtribuidas;
    private int demandasEmAndamento;
    private int demandasResolvidas;
    private String urlImagemCard; 
}
