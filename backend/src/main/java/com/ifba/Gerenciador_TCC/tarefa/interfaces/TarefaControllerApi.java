package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface TarefaControllerApi {

    public ResponseEntity<TarefaDTO> criarTarefa( AtribuirTarefaDTO tarefaDTO);
    public ResponseEntity<TarefaDTO> buscarTarefaPorId( Long id);
    public ResponseEntity<List<TarefaDTO>> listarTarefas();
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorUsuario( Long idUsuario);
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorNome( String nomeTarefa);
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorDataEnvio( LocalDate dataEnvio);
    public ResponseEntity<List<TarefaDTO>> listarTarefasPorDataFim( LocalDate dataFim);
    public ResponseEntity<Void> deletarTarefa( Long id);
    public ResponseEntity<TarefaDTO> atribuirTarefa(AtribuirTarefaDTO atribuirTarefaDTO);
    ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(Long projetoId);
}
