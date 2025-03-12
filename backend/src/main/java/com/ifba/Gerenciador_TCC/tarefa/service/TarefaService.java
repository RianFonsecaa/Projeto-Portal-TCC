package com.ifba.Gerenciador_TCC.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.builder.TarefaDTOBuilder;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

@Service
public class TarefaService implements TarefaServiceApi {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProjetoService projetoService;

    @Override
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }

    @Override
    public TarefaDTO atribuirTarefa(TarefaDTO novaTarefa) {
        Tarefa tarefa = TarefaDTOBuilder.buildTarefa(novaTarefa, usuarioService, projetoService);
        Tarefa tarefasalva = tarefaRepository.save(tarefa);
        return TarefaDTOBuilder.buildTarefaDTO(tarefasalva);
    }

    @Override
    public List<TarefaDTO> listarTarefasPorProjeto(Long projetoId) {
        List<Tarefa> tarefas = tarefaRepository.findByProjetoId(projetoId);
        return tarefas.stream()
                .map(TarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefaPorStatus(StatusTarefa statusTarefa){
        List<Tarefa> tarefas = tarefaRepository.findByStatus(statusTarefa);
        return tarefas.stream()
                .map(TarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }
}
