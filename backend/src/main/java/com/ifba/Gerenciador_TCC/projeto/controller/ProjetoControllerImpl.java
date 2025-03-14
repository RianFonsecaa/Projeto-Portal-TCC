package com.ifba.Gerenciador_TCC.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.InfoProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoController;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;

@RestController
@RequestMapping("/api/projetos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetoControllerImpl implements ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/info-projeto-orientando/{id}")
    public ResponseEntity<InfoProjetoDTO> buscarInfoProjetoPorOrientando(@PathVariable Long id){
        return ResponseEntity.ok(projetoService.buscarInfoProjetoPorOrientando(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/info-projeto-orientador/{id}")
    public ResponseEntity<List<InfoProjetoDTO>> buscarInfoProjetoPorOrientador(@PathVariable Long id){
        return ResponseEntity.ok(projetoService.buscarInfoProjetoPorOrientador(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Override
    @GetMapping("/orientador/{id}")
    public ResponseEntity<List<ProjetoDTO>> listarProjetosPorOrientador(@PathVariable Long id) {
        List<ProjetoDTO> projetos = projetoService.listarProjetosPorOrientador(id);
        return ResponseEntity.ok(projetos);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        Optional<Projeto> projeto = Optional.ofNullable(projetoService.findById(id));
        return projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
