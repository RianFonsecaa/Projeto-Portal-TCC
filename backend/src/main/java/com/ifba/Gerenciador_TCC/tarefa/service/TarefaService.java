package com.ifba.Gerenciador_TCC.tarefa.service;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.mapper.TarefaMapper;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService implements TarefaServiceApi {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    @Override
    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.dtoToTarefa(tarefaDTO);
        Tarefa tarefaSalvo = tarefaRepository.save(tarefa);
        return tarefaMapper.tarefaToDTO(tarefaSalvo);
    }

    @Override
    public TarefaDTO buscarTarefaPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado com o ID: " + id));
        return tarefaMapper.tarefaToDTO(tarefa);
    }

    @Override
    public List<TarefaDTO> listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(tarefaMapper::tarefaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorUsuario(Long idUsuario) {
        List<Tarefa> tarefas = tarefaRepository.findByIdUsuario(idUsuario);
        return tarefas.stream()
                .map(tarefaMapper::tarefaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorNome(String nomeTarefa) {
        List<Tarefa> tarefas = tarefaRepository.findByNomeTarefa(nomeTarefa);
        return tarefas.stream()
                .map(tarefaMapper::tarefaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorDataEnvio(LocalDate dataEnvio) {
        List<Tarefa> tarefas = tarefaRepository.findByDataEnvio(dataEnvio);
        return tarefas.stream()
                .map(tarefaMapper::tarefaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorDataFim(LocalDate dataFim) {
        List<Tarefa> tarefas = tarefaRepository.findByDataFim(dataFim);
        return tarefas.stream()
                .map(tarefaMapper::tarefaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }
}
