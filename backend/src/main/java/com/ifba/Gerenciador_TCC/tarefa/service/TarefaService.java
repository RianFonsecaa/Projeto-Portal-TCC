package com.ifba.Gerenciador_TCC.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemTarefa;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemTarefa.TipoTarefa;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.builder.TarefaDTOBuilder;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

@Service
public class TarefaService implements TarefaServiceApi {

    @Autowired private TarefaRepository tarefaRepository;
    @Autowired private UsuarioService usuarioService;
    @Autowired private ProjetoService projetoService;
    @Autowired private EmailService emailService;

    @Override
    public void deletarTarefa(Long id, Long idUsuario) {
        Tarefa tarefa = tarefaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
        tarefaRepository.deleteById(id);

        enviarEmailsProjeto(tarefa.getProjeto(), usuarioService.findById(idUsuario),
            new TipoMensagemTarefa(TipoTarefa.DELETAR_TAREFA, tarefa));
    }

    @Override
    public TarefaDTO criarTarefa(TarefaDTO novaTarefa, Long idUsuario) {
        Tarefa tarefaSalva = tarefaRepository.save(
            TarefaDTOBuilder.buildTarefa(novaTarefa, usuarioService, projetoService));

        enviarEmailsProjeto(tarefaSalva.getProjeto(), usuarioService.findById(idUsuario),
            new TipoMensagemTarefa(TipoTarefa.CRIAR_TAREFA, tarefaSalva));

        return TarefaDTOBuilder.buildTarefaDTO(tarefaSalva);
    }

    @Override
    public TarefaDTO editarTarefa(TarefaDTO tarefaDTO, Long idUsuario) {
        if (!tarefaRepository.existsById(tarefaDTO.getId()))
            throw new RuntimeException("Tarefa não encontrada com o ID: " + tarefaDTO.getId());
    
        Tarefa tarefaConvertida = TarefaDTOBuilder.buildTarefa(tarefaDTO, usuarioService, projetoService);
    
        Tarefa tarefaSalva = tarefaRepository.save(tarefaConvertida);
    
        enviarEmailsProjeto(tarefaSalva.getProjeto(), usuarioService.findById(idUsuario),
            new TipoMensagemTarefa(TipoTarefa.EDITAR_TAREFA, tarefaDTO));
    
        return TarefaDTOBuilder.buildTarefaDTO(tarefaSalva);
    }
    

    @Override
    public List<TarefaDTO> listarTarefasPorProjeto(Long projetoId) {
        return tarefaRepository.findByProjetoId(projetoId).stream()
            .map(TarefaDTOBuilder::buildTarefaDTO).collect(Collectors.toList());
    }

    @Override
    public List<TarefaDTO> listarTarefaPorStatus(StatusTarefa statusTarefa) {
        return tarefaRepository.findByStatus(statusTarefa).stream()
            .map(TarefaDTOBuilder::buildTarefaDTO).collect(Collectors.toList());
    }

    private void enviarEmailsProjeto(Projeto projeto, Usuario usuario, TipoMensagem tipoMensagem) {
        switch (usuario.getTipoUsuario()) {
            case ORIENTANDO -> emailService.enviarEmail(
                projeto.getOrientadorId().getEmail(),
                tipoMensagem,
                projeto.getOrientandoId().getNome()
            );
            case ORIENTADOR -> emailService.enviarEmail(
                projeto.getOrientandoId().getEmail(),
                tipoMensagem,
                projeto.getOrientadorId().getNome()
            );
            default -> throw new IllegalArgumentException("Tipo de usuário desconhecido: " + usuario.getTipoUsuario());
        }
    }
}