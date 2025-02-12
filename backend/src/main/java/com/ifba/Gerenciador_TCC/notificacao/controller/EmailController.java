package com.ifba.Gerenciador_TCC.notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ifba.Gerenciador_TCC.notificacao.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarEmail(@RequestParam String para, 
                              @RequestParam String assunto, 
                              @RequestParam String mensagem) {
        emailService.enviarEmail(para, assunto, mensagem);
        return "E-mail enviado com sucesso!";
    }
}
