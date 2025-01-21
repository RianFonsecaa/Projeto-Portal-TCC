package com.ifba.Gerenciador_TCC.tcc.controller;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.service.TccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tccs")
public class TccController implements TccControllerApi {

    @Autowired
    private TccService tccService;

    @Override
    @PostMapping
    public ResponseEntity<TccDTO> criarTcc(@RequestBody TccDTO tccDTO) {
        TccDTO novoTcc = tccService.criarTcc(tccDTO);
        return ResponseEntity.ok(novoTcc);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TccDTO> buscarTccPorId(@PathVariable Long id) {
        TccDTO tcc = tccService.buscarTccPorId(id);
        return ResponseEntity.ok(tcc);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TccDTO>> listarTccs() {
        List<TccDTO> tccs = tccService.listarTccs();
        return ResponseEntity.ok(tccs);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TccDTO> atualizarTcc(@PathVariable Long id, @RequestBody TccDTO tccDTO) {
        TccDTO tccAtualizado = tccService.atualizarTcc(id, tccDTO);
        return ResponseEntity.ok(tccAtualizado);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTcc(@PathVariable Long id) {
        tccService.deletarTcc(id);
        return ResponseEntity.noContent().build();
    }
}
