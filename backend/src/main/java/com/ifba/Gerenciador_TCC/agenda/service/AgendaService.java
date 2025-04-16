package com.ifba.Gerenciador_TCC.agenda.service;

import com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO;
import com.ifba.Gerenciador_TCC.agenda.interfaces.AgendaServiceInterface;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgendaService implements AgendaServiceInterface {
    @Autowired
    TarefaRepository tarefaRepository;
    @Override
    public List<TarefaAgendaDTO> listarAgendaPorOrientador(Long orientadorId) {
        return tarefaRepository.findAgendaByOrientador(orientadorId);
    }

    @Override
    public List<TarefaAgendaDTO> listarAgendaPorOrientando(Long orientandoId) {
        return tarefaRepository.findAgendaByOrientando(orientandoId);
    }
}
