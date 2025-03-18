package com.ifba.Gerenciador_TCC.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
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

    @Autowired
    private EmailService emailService; 
    
    


    @Override
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
    
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    
        Projeto projeto = tarefa.getProjeto();


        emailService.enviarEmail(
            projeto.getOrientadorId().getEmail(),  
            TipoMensagem.ADVERTENCIA,              
            projeto.getOrientadorId().getNome()    
        );
    
        emailService.enviarEmail(
            projeto.getOrientandoId().getEmail(), 
            TipoMensagem.ADVERTENCIA,              
            projeto.getOrientadorId().getNome()   
        );
    
        tarefaRepository.deleteById(id);
    }
    
    @Override
    public TarefaDTO criarTarefa(TarefaDTO novaTarefa) {
        Tarefa tarefa = TarefaDTOBuilder.buildTarefa(novaTarefa, usuarioService, projetoService);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        Projeto projeto = tarefaSalva.getProjeto();
    
        emailService.enviarEmail(
            projeto.getOrientadorId().getEmail(), 
            TipoMensagem.INFORMACAO, 
            projeto.getOrientandoId().getNome()  
        );
    
     
        emailService.enviarEmail(
            projeto.getOrientandoId().getEmail(), 
            TipoMensagem.INFORMACAO, 
            projeto.getOrientadorId().getNome() 
        );
    

        return TarefaDTOBuilder.buildTarefaDTO(tarefaSalva);
    }       


    
    @Override
    public TarefaDTO editarTarefa(TarefaDTO tarefa) {
        if (!tarefaRepository.existsById(tarefa.getId())) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + tarefa.getId());
        }
      

        Projeto projeto = projetoService.findById(tarefa.getProjetoId());

        emailService.enviarEmail(
            projeto.getOrientadorId().getEmail(), 
            TipoMensagem.ATUALIZACAO, 
            projeto.getOrientandoId().getNome()  
        );

        emailService.enviarEmail(
            projeto.getOrientandoId().getEmail(),
            TipoMensagem.ATUALIZACAO,
            projeto.getOrientadorId().getNome()
        );
    
        
        return criarTarefa(tarefa);  
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
