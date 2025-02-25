package com.ifba.Gerenciador_TCC.projeto.controller;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoController;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.projeto.repository.ProjetoRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projetos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetoControllerImpl implements ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<Projeto>> listarProjetos() {
        List<Projeto> projetos = projetoService.listarProjetos();
        return ResponseEntity.ok(projetos);
    }

    @Override
    @GetMapping("/orientador/{id}")
    public ResponseEntity<List<Projeto>> listarProjetosPorOrientador(@PathVariable Long id) {
        List<Projeto> projetos = projetoService.listarProjetosPorOrientador(id);
        return ResponseEntity.ok(projetos);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> obterProjetoPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = Optional.ofNullable(projetoService.obterProjetoPorId(id));
        return projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoService.criarProjeto(projeto);
        return ResponseEntity.ok(projetoSalvo);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoService.atualizarProjeto(projeto);
        return ResponseEntity.ok(projetoSalvo);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
