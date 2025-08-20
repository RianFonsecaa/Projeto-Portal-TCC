package com.ifba.Gerenciador_TCC.usuario.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioOrientadorDTO {
    private Long id;
    private String nome;
    private String email;
    private String areaPesquisa;
    private String cargo;
    private boolean orientadorDisponivel;
    private Long projetosEmOrientacao;
    private String resumo;
    private String telefone;
}
