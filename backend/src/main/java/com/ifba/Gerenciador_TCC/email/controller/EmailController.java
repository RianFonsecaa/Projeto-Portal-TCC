package com.ifba.Gerenciador_TCC.email.controller;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemComum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarEmail(@RequestParam String para,
                              @RequestParam String tipo,  
                              @RequestParam String remetenteNotificacao) {

       
        TipoMensagemComum tipoMensagemComum = new TipoMensagemComum(tipo);

        
        return emailService.enviarEmail(para, tipoMensagemComum, remetenteNotificacao);
    }
}
