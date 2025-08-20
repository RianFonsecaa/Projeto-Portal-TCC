package com.ifba.Gerenciador_TCC.usuario.interfaces;

import com.ifba.Gerenciador_TCC.login.domain.LoginRequest;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioControllerApi {
    public ResponseEntity<?> login(LoginRequest loginRequest);
    public ResponseEntity<List<Usuario>> getAllUsuarios();
}
