package com.ifba.Gerenciador_TCC.usuario.builder;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioOrientandoDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Orientando;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;

public class UsuarioOrientandoBuilder {
    public static UsuarioOrientandoDTO buildUsuarioOrientandoDTO(Usuario usuario, Orientando orientando){
        return UsuarioOrientandoDTO.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .tipoCurso(orientando.getTipoCurso())
                .build();
    }
}
