package com.ifba.Gerenciador_TCC.quadrodemandas.controller;

import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.quadrodemandas.service.QuadroDemandasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quadro-demandas")
public class QuadroDemandasController {

    @Autowired
    private QuadroDemandasService quadroDemandasService;

    @PostMapping
    public ResponseEntity<QuadroDemandasDTO> criarQuadroDemandas(@RequestBody QuadroDemandasDTO quadroDemandasDTO) {
        return ResponseEntity.ok(quadroDemandasService.criarQuadroDemandas(quadroDemandasDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuadroDemandasDTO> buscarQuadroDemandasPorId(@PathVariable Long id) {
        return ResponseEntity.ok(quadroDemandasService.buscarQuadroDemandasPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<QuadroDemandasDTO>> listarQuadrosDemandas() {
        return ResponseEntity.ok(quadroDemandasService.listarQuadrosDemandas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarQuadroDemandas(@PathVariable Long id) {
        quadroDemandasService.deletarQuadroDemandas(id);
        return ResponseEntity.noContent().build();
    }
}