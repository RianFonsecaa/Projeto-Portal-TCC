package com.ifba.Gerenciador_TCC.agenda.interfaces;

import com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO;

import java.util.List;

public interface AgendaServiceInterface {
    public List<TarefaAgendaDTO> listarAgendaPorOrientador(Long orientadorId);
    public List<TarefaAgendaDTO> listarAgendaPorOrientando(Long orientandoId);
}
