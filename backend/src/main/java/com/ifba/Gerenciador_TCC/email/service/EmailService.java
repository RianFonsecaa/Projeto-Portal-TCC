package com.ifba.Gerenciador_TCC.email.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.notificacao.service.NotificacaoService;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificacaoService notificacaoService;

    @Value("${spring.mail.username}")
    private String remetente;

    private String construirMensagem(TipoMensagem tipo, String remetenteNotificacao) {
        String dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        return tipo.gerarMensagem() + "\n\n📅 Data: " + dataAtual + "\n\nAtenciosamente,\n" + remetenteNotificacao;
    }
    
    @Async
    public void enviarEmail(String destinatario, TipoMensagem tipo, String remetenteNotificacao) {
        try {
            String mensagem = construirMensagem(tipo, remetenteNotificacao);
            String assunto = tipo.getAssunto(); 
    
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);
    
            mailSender.send(simpleMailMessage);
            notificacaoService.criarNotificacao(remetenteNotificacao, destinatario, assunto, mensagem);
    
        } catch (Exception e) {
            e.printStackTrace(); // você pode logar isso em um logger se preferir
        }
    }
}
