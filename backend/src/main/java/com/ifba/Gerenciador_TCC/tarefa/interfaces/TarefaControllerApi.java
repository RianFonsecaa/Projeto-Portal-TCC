package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaAgendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

@RequestMapping("/api/tarefa")
public interface TarefaControllerApi {

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa);
    
    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa);

    @GetMapping("/{projetoId}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId);
}
