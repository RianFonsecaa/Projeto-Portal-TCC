package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

public interface TarefaControllerApi {

    public ResponseEntity<Void> deletarTarefa( Long id);
    public ResponseEntity<TarefaDTO> atribuirTarefa(TarefaDTO tarefaDTO);
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(Long projetoId);
}
