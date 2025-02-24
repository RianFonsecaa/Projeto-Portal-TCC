package com.ifba.Gerenciador_TCC.usuario.controller;

import lombok.Data;

@Data
public class JwtResponse {
    private final String jwtToken;
    private final Long usuarioId;

    public JwtResponse(String jwtToken, Long usuarioId) {
        this.jwtToken = jwtToken;
        this.usuarioId = usuarioId;
    }

}