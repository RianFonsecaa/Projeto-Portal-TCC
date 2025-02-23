package com.ifba.Gerenciador_TCC.email.controller;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarEmail(@RequestParam String para,
                              @RequestParam TipoMensagem tipo,
                              @RequestParam String remetenteNotificacao) {
        return emailService.enviarEmail(para, tipo, remetenteNotificacao);
    }
}
