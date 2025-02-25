package com.ifba.Gerenciador_TCC.projeto.controller;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoController;
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
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<Projeto>> listarProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return ResponseEntity.ok(projetos);
    }

    @Override
    @GetMapping("/orientador/{id}")
    public ResponseEntity<List<Projeto>> listarProjetosPorOrientador(@PathVariable Long idOrientador) {
        List<Projeto> projetos = projetoRepository.findByOrientadorId(usuarioService.findById(idOrientador));
        return ResponseEntity.ok(projetos);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> obterProjetoPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoRepository.save(projeto);
        return ResponseEntity.ok(projetoSalvo);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        if (projetoRepository.existsById(id)) {
            projeto.setId(id);
            Projeto projetoAtualizado = projetoRepository.save(projeto);
            return ResponseEntity.ok(projetoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
