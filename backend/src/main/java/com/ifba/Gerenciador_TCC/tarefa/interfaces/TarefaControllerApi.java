
package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

@RequestMapping("/api/tarefa")
public interface TarefaControllerApi {

    @DeleteMapping("/{id}/usuario/{idUsuario}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id, @PathVariable Long idUsuario);

    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa, @PathVariable Long idUsuario);
    
    @PutMapping("/{id}/usuario/{idUsuario}")
    public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa, @PathVariable Long idUsuario);

    @GetMapping("/{projetoId}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId);
}
