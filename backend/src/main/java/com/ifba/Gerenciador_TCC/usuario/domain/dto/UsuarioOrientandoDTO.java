package com.ifba.Gerenciador_TCC.usuario.domain.dto;

import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioOrientandoDTO {
    private Long id;
    private String nome;
    private String email;
    private TipoCurso tipoCurso;
}
