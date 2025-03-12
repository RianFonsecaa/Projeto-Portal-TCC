package com.ifba.Gerenciador_TCC.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaControllerApi;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController implements TarefaControllerApi {

    @Autowired
    private TarefaService tarefaService;

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<TarefaDTO> atribuirTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaAtribuidaDTO = tarefaService.atribuirTarefa(tarefaDTO);
        return ResponseEntity.ok(tarefaAtribuidaDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{projetoId}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
    List<TarefaDTO> tarefas = tarefaService.listarTarefasPorProjeto(projetoId);
    return ResponseEntity.ok(tarefas);
    }

}
