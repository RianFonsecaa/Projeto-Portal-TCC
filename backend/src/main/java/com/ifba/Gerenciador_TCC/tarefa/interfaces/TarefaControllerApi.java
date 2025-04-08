package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tarefa")
public interface TarefaControllerApi {

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarTarefa(@PathVariable Long id, @RequestParam Long idUsuario);

    @PostMapping
    ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa, @RequestParam Long idUsuario);
    
    @PutMapping("/{id}")
    ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa, @RequestParam Long idUsuario);

    @GetMapping("/{projetoId}")
    ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId);
}
