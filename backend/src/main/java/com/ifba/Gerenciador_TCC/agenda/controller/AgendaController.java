package com.ifba.Gerenciador_TCC.agenda.controller;

import com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO;
import com.ifba.Gerenciador_TCC.agenda.interfaces.AgendaServiceInterface;
import com.ifba.Gerenciador_TCC.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendaController {

    @Autowired
    AgendaServiceInterface agendaService;

    @GetMapping("/orientador/{orientadorId}")
    public ResponseEntity<List<TarefaAgendaDTO>> listarTarefaAgendaPorOrientador(@PathVariable Long orientadorId) {
        return ResponseEntity.ok(agendaService.listarAgendaPorOrientador(orientadorId));
    }

    @GetMapping("/orientando/{orientandoId}")
    public ResponseEntity<List<TarefaAgendaDTO>> listarTarefaAgendaPorOrientando(@PathVariable Long orientandoId) {
        return ResponseEntity.ok(agendaService.listarAgendaPorOrientando(orientandoId));
    }
}
