package com.ifba.Gerenciador_TCC.tipousuario.controller;

import com.ifba.Gerenciador_TCC.tipousuario.interfaces.TipoUsuarioControllerApi;
import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-usuarios")
public class TipoUsuarioController implements TipoUsuarioControllerApi {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<TipoUsuarioDTO> criarTipoUsuario(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuarioDTO tipoUsuarioCriado = tipoUsuarioService.criarTipoUsuario(tipoUsuarioDTO);
        return ResponseEntity.ok(tipoUsuarioCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> buscarTipoUsuarioPorId(@PathVariable Long id) {
        TipoUsuarioDTO tipoUsuario = tipoUsuarioService.buscarTipoUsuarioPorId(id);
        return ResponseEntity.ok(tipoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> listarTipoUsuarios() {
        List<TipoUsuarioDTO> tipoUsuarios = tipoUsuarioService.listarTipoUsuarios();
        return ResponseEntity.ok(tipoUsuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoUsuario(@PathVariable Long id) {
        tipoUsuarioService.deletarTipoUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
