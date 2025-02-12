package com.ifba.Gerenciador_TCC.tarefa.service;

import com.ifba.Gerenciador_TCC.tarefa.builder.AtribuirTarefaDTOBuilder;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.AtribuirTarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;
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
    private UsuarioService usuarioService;

    @Override
    public TarefaDTO criarTarefa(AtribuirTarefaDTO tarefaDTO) {
        Tarefa tarefa = AtribuirTarefaDTOBuilder.buildTarefa(tarefaDTO, usuarioService);
        Tarefa tarefaSalvo = tarefaRepository.save(tarefa);
        return AtribuirTarefaDTOBuilder.buildTarefaDTO(tarefaSalvo);
    }

    @Override
    public TarefaDTO buscarTarefaPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado com o ID: " + id));
        return AtribuirTarefaDTOBuilder.buildTarefaDTO(tarefa);
    }

    @Override
    public List<TarefaDTO> listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(AtribuirTarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorUsuario(Long idUsuario) {
        List<Tarefa> tarefas = tarefaRepository.findByOrientandoId(idUsuario);
        return tarefas.stream()
                .map(AtribuirTarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorNome(String nomeTarefa) {
        List<Tarefa> tarefas = tarefaRepository.findByNomeTarefa(nomeTarefa);
        return tarefas.stream()
                .map(AtribuirTarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorDataEnvio(LocalDate dataEnvio) {
        List<Tarefa> tarefas = tarefaRepository.findByDataEnvio(dataEnvio);
        return tarefas.stream()
                .map(AtribuirTarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefasPorDataFim(LocalDate dataFim) {
        List<Tarefa> tarefas = tarefaRepository.findByDataFim(dataFim);
        return tarefas.stream()
                .map(AtribuirTarefaDTOBuilder::buildTarefaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }

    @Override
    public TarefaDTO atribuirTarefa(AtribuirTarefaDTO atribuirTarefaDTO) {
        Tarefa tarefa = AtribuirTarefaDTOBuilder.buildTarefa(atribuirTarefaDTO, usuarioService);
        Tarefa tarefasalva = tarefaRepository.save(tarefa);
        return AtribuirTarefaDTOBuilder.buildTarefaDTO(tarefasalva);
    }
}
