package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;

import java.time.LocalDate;
import java.util.List;

public interface TarefaServiceApi {

    TarefaDTO criarTarefa(AtribuirTarefaDTO tarefaDTO);

    TarefaDTO buscarTarefaPorId(Long id);

    List<TarefaDTO> listarTarefas();

    List<TarefaDTO> listarTarefasPorUsuario(Long idUsuario);

    List<TarefaDTO> listarTarefasPorNome(String nomeTarefa);

    List<TarefaDTO> listarTarefasPorDataEnvio(LocalDate dataEnvio);

    List<TarefaDTO> listarTarefasPorDataFim(LocalDate dataEnvio);

    void deletarTarefa(Long id);

    TarefaDTO atribuirTarefa(AtribuirTarefaDTO atribuirTarefaDTO);

    List<TarefaDTO> listarTarefasPorProjeto(Long projetoId);

}
