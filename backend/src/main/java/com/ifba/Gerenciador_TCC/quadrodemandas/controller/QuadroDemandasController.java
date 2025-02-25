package com.ifba.Gerenciador_TCC.quadrodemandas.controller;

import com.ifba.Gerenciador_TCC.quadrodemandas.service.QuadroDemandasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quadro-demandas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuadroDemandasController {

    @Autowired
    private QuadroDemandasService quadroDemandasService;

    @GetMapping("/orientador/{id}")
    private ResponseEntity<?> buscarQuadroPorOrientador(@PathVariable Long id){
        return ResponseEntity.ok(quadroDemandasService.buscarQuadroPorOrientador(id));
    }

}