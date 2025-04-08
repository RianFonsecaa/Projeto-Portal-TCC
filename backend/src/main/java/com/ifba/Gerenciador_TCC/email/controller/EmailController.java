package com.ifba.Gerenciador_TCC.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagemComum;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public void enviarEmail(@RequestParam String para,
                              @RequestParam String tipo,  
                              @RequestParam String remetenteNotificacao) {

       
        TipoMensagemComum tipoMensagemComum = new TipoMensagemComum(tipo);

        
        emailService.enviarEmail(para, tipoMensagemComum, remetenteNotificacao);
    }
}
