package com.ifba.Gerenciador_TCC.tipoprojeto.controller;

import com.ifba.Gerenciador_TCC.tipoprojeto.interfaces.TipoProjetoControllerApi;
import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;
import com.ifba.Gerenciador_TCC.tipoprojeto.service.TipoProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-projetos")
public class TipoProjetoController implements TipoProjetoControllerApi {

    @Autowired
    private TipoProjetoService tipoProjetoService;

    @PostMapping
    public ResponseEntity<TipoProjetoDTO> criarTipoProjeto(@RequestBody TipoProjetoDTO tipoProjetoDTO) {
        TipoProjetoDTO tipoProjetoCriado = tipoProjetoService.criarTipoProjeto(tipoProjetoDTO);
        return ResponseEntity.ok(tipoProjetoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProjetoDTO> buscarTipoProjetoPorId(@PathVariable Long id) {
        TipoProjetoDTO tipoProjeto = tipoProjetoService.buscarTipoProjetoPorId(id);
        return ResponseEntity.ok(tipoProjeto);
    }

    @GetMapping
    public ResponseEntity<List<TipoProjetoDTO>> listarTipoProjetos() {
        List<TipoProjetoDTO> tipoProjetos = tipoProjetoService.listarTipoProjetos();
        return ResponseEntity.ok(tipoProjetos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoProjeto(@PathVariable Long id) {
        tipoProjetoService.deletarTipoProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
