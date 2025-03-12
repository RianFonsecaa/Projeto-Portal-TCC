package com.ifba.Gerenciador_TCC.tarefa.interfaces;

import java.util.List;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;

public interface TarefaServiceApi {

    List<TarefaDTO> listarTarefaPorStatus(StatusTarefa statusTarefa);

    void deletarTarefa(Long id);

    TarefaDTO atribuirTarefa(TarefaDTO tarefaDTO);

    List<TarefaDTO> listarTarefasPorProjeto(Long projetoId);

}
