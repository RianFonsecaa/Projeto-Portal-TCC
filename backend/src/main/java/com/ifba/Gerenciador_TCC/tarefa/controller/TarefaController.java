package com.ifba.Gerenciador_TCC.tarefa.controller;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaControllerApi;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController implements TarefaControllerApi {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody AtribuirTarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriado = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.ok(tarefaCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarTarefaPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarTarefas() {
        List<TarefaDTO> tarefas = tarefaService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorUsuario(@PathVariable Long idUsuario) {
        List<TarefaDTO> tarefas = tarefaService.listarTarefasPorUsuario(idUsuario);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorNome(@RequestParam String nomeTarefa) {
        List<TarefaDTO> tarefas = tarefaService.listarTarefasPorNome(nomeTarefa);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/data-envio")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorDataEnvio(@RequestParam LocalDate dataEnvio) {
        List<TarefaDTO> tarefas = tarefaService.listarTarefasPorDataEnvio(dataEnvio);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/data-fim")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorDataFim(@RequestParam LocalDate dataFim) {
        List<TarefaDTO> tarefas = tarefaService.listarTarefasPorDataFim(dataFim);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/atribuir")
    public ResponseEntity<TarefaDTO> atribuirTarefa(@RequestBody AtribuirTarefaDTO atribuirTarefaDTO) {
        TarefaDTO tarefaAtribuidaDTO = tarefaService.atribuirTarefa(atribuirTarefaDTO);
        return ResponseEntity.ok(tarefaAtribuidaDTO);
    }

    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
    List<TarefaDTO> tarefas = tarefaService.listarTarefasPorProjeto(projetoId);
    return ResponseEntity.ok(tarefas);
    }

}
