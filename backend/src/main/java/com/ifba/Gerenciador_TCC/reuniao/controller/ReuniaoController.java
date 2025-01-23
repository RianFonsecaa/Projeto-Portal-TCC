package com.ifba.Gerenciador_TCC.reuniao.controller;

import com.ifba.Gerenciador_TCC.reuniao.interfaces.ReuniaoControllerApi;
import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;
import com.ifba.Gerenciador_TCC.reuniao.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reunioes")
public class ReuniaoController implements ReuniaoControllerApi {

    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping
    public ResponseEntity<ReuniaoDTO> criarReuniao(@RequestBody ReuniaoDTO reuniaoDTO) {
        ReuniaoDTO reuniaoCriado = reuniaoService.criarReuniao(reuniaoDTO);
        return ResponseEntity.ok(reuniaoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReuniaoDTO> buscarReuniaoPorId(@PathVariable Long id) {
        ReuniaoDTO reuniao = reuniaoService.buscarReuniaoPorId(id);
        return ResponseEntity.ok(reuniao);
    }

    @GetMapping
    public ResponseEntity<List<ReuniaoDTO>> listarReunioes() {
        List<ReuniaoDTO> reunioes = reuniaoService.listarReunioes();
        return ResponseEntity.ok(reunioes);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ReuniaoDTO>> listarReunioesPorNome(@RequestParam String nomeReuniao) {
        List<ReuniaoDTO> reunioes = reuniaoService.listarReunioesPorNome(nomeReuniao);
        return ResponseEntity.ok(reunioes);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReuniaoDTO>> listarReunioesPorUsuario(@PathVariable Long idUsuario) {
        List<ReuniaoDTO> reunioes = reuniaoService.listarReunioesPorUsuario(idUsuario);
        return ResponseEntity.ok(reunioes);
    }


    @GetMapping("/data")
    public ResponseEntity<List<ReuniaoDTO>> listarReunioesPorData(@RequestParam LocalDate dataReuniao) {
        List<ReuniaoDTO> reunioes = reuniaoService.listarReunioesPorData(dataReuniao);
        return ResponseEntity.ok(reunioes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReuniao(@PathVariable Long id) {
        reuniaoService.deletarReuniao(id);
        return ResponseEntity.noContent().build();
    }
}
