package com.ifba.Gerenciador_TCC.tipocurso.controller;

import com.ifba.Gerenciador_TCC.tipocurso.interfaces.TipoCursoControllerApi;
import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.service.TipoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-cursos")
public class TipoCursoController implements TipoCursoControllerApi {

    @Autowired
    private TipoCursoService tipoCursoService;

    @PostMapping
    public ResponseEntity<TipoCursoDTO> criarTipoCurso(@RequestBody TipoCursoDTO tipoCursoDTO) {
        TipoCursoDTO tipoCursoCriado = tipoCursoService.criarTipoCurso(tipoCursoDTO);
        return ResponseEntity.ok(tipoCursoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCursoDTO> buscarTipoCursoPorId(@PathVariable Long id) {
        TipoCursoDTO tipoCurso = tipoCursoService.buscarTipoCursoPorId(id);
        return ResponseEntity.ok(tipoCurso);
    }

    @GetMapping
    public ResponseEntity<List<TipoCursoDTO>> listarTipoCursos() {
        List<TipoCursoDTO> tipoCursos = tipoCursoService.listarTipoCursos();
        return ResponseEntity.ok(tipoCursos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoCurso(@PathVariable Long id) {
        tipoCursoService.deletarTipoCurso(id);
        return ResponseEntity.noContent().build();
    }
}
