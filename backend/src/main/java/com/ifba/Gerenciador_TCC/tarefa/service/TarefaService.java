package com.ifba.Gerenciador_TCC.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaAgendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.builder.TarefaDTOBuilder;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import com.ifba.Gerenciador_TCC.tipoenum.TipoUsuario;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemTarefa;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemTarefa.TipoTarefa;

@Service
public class TarefaService implements TarefaServiceApi {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private EmailService emailService; 
    


    
    @Override
    public void deletarTarefa(Long id, Long idUsuario) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        Projeto projeto = tarefa.getProjeto();
        Usuario usuario = usuarioService.findById(idUsuario);

        TipoMensagemTarefa mensagem = new TipoMensagemTarefa(TipoTarefa.DELETAR_TAREFA, tarefa);
        enviarEmailsProjeto(projeto, usuario, mensagem);

        tarefaRepository.deleteById(id);
    }

    @Override
    public TarefaDTO criarTarefa(TarefaDTO novaTarefa, Long idUsuario) {
        Tarefa tarefa = TarefaDTOBuilder.buildTarefa(novaTarefa, usuarioService, projetoService);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        Projeto projeto = tarefaSalva.getProjeto();
        Usuario usuario = usuarioService.findById(idUsuario);

        TipoMensagemTarefa mensagem = new TipoMensagemTarefa(TipoTarefa.CRIAR_TAREFA, tarefaSalva);
        enviarEmailsProjeto(projeto, usuario, mensagem);

    return TarefaDTOBuilder.buildTarefaDTO(tarefaSalva);
    }


    @Override
    public TarefaDTO editarTarefa(TarefaDTO tarefa, Long idUsuario) {
        if (!tarefaRepository.existsById(tarefa.getId())) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + tarefa.getId());
        }

        Projeto projeto = projetoService.findById(tarefa.getProjetoId());
        Usuario usuario = usuarioService.findById(idUsuario);

        TipoMensagemTarefa mensagem = new TipoMensagemTarefa(TipoTarefa.EDITAR_TAREFA, tarefa);
        enviarEmailsProjeto(projeto, usuario, mensagem);

        return criarTarefa(tarefa, idUsuario);
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

    private void enviarEmailsProjeto(Projeto projeto, Usuario usuario, TipoMensagem tipoMensagem) {
        if (usuario.getTipoUsuario() == TipoUsuario.ORIENTANDO) {
            emailService.enviarEmail(
                projeto.getOrientadorId().getEmail(),
                tipoMensagem,
                projeto.getOrientandoId().getNome()
            );
        } else if (usuario.getTipoUsuario() == TipoUsuario.ORIENTADOR) {
            
            emailService.enviarEmail(
                projeto.getOrientandoId().getEmail(),
                tipoMensagem,
                projeto.getOrientadorId().getNome()
            );
        }
    }
    
    
}