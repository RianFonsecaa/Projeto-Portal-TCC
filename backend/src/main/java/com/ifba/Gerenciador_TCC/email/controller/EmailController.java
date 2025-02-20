package com.ifba.Gerenciador_TCC.email.controller;

import com.ifba.Gerenciador_TCC.email.service.EmailService;
import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-template")
    public String enviarEmailComTemplate(@RequestParam String para,
                                         @RequestParam String assunto,
                                         @RequestParam TipoMensagem tipo,
                                         @RequestParam String conteudo,
                                         @RequestParam String remetenteNotificacao) {
        return emailService.enviarEmailComTemplate(para, assunto, tipo, conteudo, remetenteNotificacao);
    }

    @PostMapping("/enviar-simples")
    public String enviarEmailSimples(@RequestParam String para,
                                     @RequestParam String assunto,
                                     @RequestParam String mensagem) {
        emailService.enviarEmail(para, assunto, mensagem);
        return "E-mail enviado sem notificação!";
    }
}
