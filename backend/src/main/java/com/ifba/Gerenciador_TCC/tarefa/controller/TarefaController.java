package com.ifba.Gerenciador_TCC.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.interfaces.TarefaControllerApi;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController implements TarefaControllerApi {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private EmailService emailService; 

    public ResponseEntity<Void> deletarTarefa(Long id) {
        tarefaService.deletarTarefa(id);

        emailService.enviarEmail(
            "destinatario@example.com",
            TipoMensagem.ADVERTENCIA,  
            "Sistema Gerenciador TCC"
        );

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<TarefaDTO> criarTarefa(TarefaDTO novaTarefa) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(novaTarefa);

       
        emailService.enviarEmail(
            "destinatario@example.com", 
            TipoMensagem.NOTIFICACAO,  
            "Sistema Gerenciador TCC"
        );

        return ResponseEntity.ok(tarefaCriada);
    }

    public ResponseEntity<TarefaDTO> editarTarefa(Long id, TarefaDTO tarefa) {
        tarefa.setId(id);
        TarefaDTO tarefaEditada = tarefaService.editarTarefa(tarefa);

       
        emailService.enviarEmail(
            "destinatario@example.com", 
            TipoMensagem.NOTIFICACAO,  
            "Sistema Gerenciador TCC"
        );

        return ResponseEntity.ok(tarefaEditada);
    }

    public ResponseEntity<List<TarefaDTO>> listarTarefasPorProjeto(@PathVariable Long projetoId) {
        return ResponseEntity.ok(tarefaService.listarTarefasPorProjeto(projetoId));
    }
}
