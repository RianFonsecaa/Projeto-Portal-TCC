package com.ifba.Gerenciador_TCC.usuario.builder;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioOrientadorDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Orientador;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;

public class UsuarioOrientadorBuilder {
    public static UsuarioOrientadorDTO buildUsuarioOrientadorDTO(Usuario usuario, Orientador orientador){
        return UsuarioOrientadorDTO.builder()
                .id(usuario.getId())
                .cargo(orientador.getCargo())
                .projetosEmOrientacao(orientador.getProjetosEmOrientacao())
                .orientadorDisponivel(orientador.isOrientadorDisponivel())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .resumo(orientador.getResumo())
                .telefone(usuario.getTelefone())
                .areaPesquisa(orientador.getAreaPesquisa())
                .build();
    }
}
