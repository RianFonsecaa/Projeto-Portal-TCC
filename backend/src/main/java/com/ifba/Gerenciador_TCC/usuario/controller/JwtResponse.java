package com.ifba.Gerenciador_TCC.usuario.controller;

import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;

public class JwtResponse {
    private final String jwtToken;
    private final Usuario usuario;

    public JwtResponse(String jwtToken, Usuario usuario) {
        this.jwtToken = jwtToken;
        this.usuario = usuario;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}