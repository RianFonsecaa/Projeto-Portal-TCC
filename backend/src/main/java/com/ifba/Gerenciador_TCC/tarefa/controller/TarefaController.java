package com.ifba.Gerenciador_TCC.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaControllerApi;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tarefa")
public class TarefaController implements TarefaControllerApi {

    @Autowired
    private TarefaService tarefaService;

    @DeleteMapping("/{id}/usuario/{idUsuario}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id, @PathVariable Long idUsuario) {
        tarefaService.deletarTarefa(id, idUsuario);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa, @PathVariable Long idUsuario) {
        return ResponseEntity.ok(tarefaService.criarTarefa(novaTarefa, idUsuario));
    }

    @PutMapping("/{id}/usuario/{idUsuario}")
    public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa, @PathVariable Long idUsuario) {
        tarefa.setId(id);
        return ResponseEntity.ok(tarefaService.editarTarefa(tarefa, idUsuario));
    }

    @GetMapping("/{projetoId}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
        return ResponseEntity.ok(tarefaService.listarTarefasPorProjeto(projetoId));
    }
}
