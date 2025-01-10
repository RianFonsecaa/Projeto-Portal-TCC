package com.ifba.Gerenciador_TCC.usuario.controller;

import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioControllerApi;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;
import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Acho que preciso dar uma refinada nisso aqui

@RestController
@RequestMapping("/dashboard")
public class UsuarioController implements UsuarioControllerApi {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{posicao}")
    public ResponseEntity<String> login(@PathVariable String posicao, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = usuarioService.login(email, senha);
        if (usuario != null && posicao.equalsIgnoreCase(usuario.getPosicao())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return NotFoundException("Email ou senha inválidos!");
    }

    @GetMapping
    public ResponseEntity<Void> redirecionar(@RequestParam long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            String posicao = usuario.getPosicao();
            return ResponseEntity.status(HttpStatus.FOUND)
                                 .location(URI.create("/dashboard/" + posicao))
                                 .build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
