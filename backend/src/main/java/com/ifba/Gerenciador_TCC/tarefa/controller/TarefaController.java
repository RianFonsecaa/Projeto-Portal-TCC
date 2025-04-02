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

    @Override
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id, @RequestParam Long idUsuario) {
        tarefaService.deletarTarefa(id, idUsuario);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa, @RequestParam Long idUsuario) {
        return ResponseEntity.ok(tarefaService.criarTarefa(novaTarefa, idUsuario));
    }

    @Override
    public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefa, @RequestParam Long idUsuario) {
        tarefa.setId(id);
        return ResponseEntity.ok(tarefaService.editarTarefa(tarefa, idUsuario));
    }

    @Override
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
        return ResponseEntity.ok(tarefaService.listarTarefasPorProjeto(projetoId));
    }
}
