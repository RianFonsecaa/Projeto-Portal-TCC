package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

@RequestMapping("/api/tarefa")
public interface TarefaControllerApi {

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarTarefa(@PathVariable Long id, @RequestParam Long idUsuario);

    @PostMapping
    ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa, @RequestParam Long idUsuario);
    
    @PutMapping("/{id}")
    ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa, @RequestParam Long idUsuario);

    @GetMapping("/projeto/{projetoId}")
    ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId);
}
