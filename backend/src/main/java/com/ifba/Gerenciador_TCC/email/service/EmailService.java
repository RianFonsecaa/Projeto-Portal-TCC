package com.ifba.Gerenciador_TCC.email.service;

import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.notificacao.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return tipo.getMensagem() + "\n\n📅 Data: " + dataAtual + "\n\nAtenciosamente,\n" + remetenteNotificacao;
    }

    public String enviarEmail(String destinatario, TipoMensagem tipo, String remetenteNotificacao) {
        try {
            String mensagem = construirMensagem(tipo, remetenteNotificacao);
            String assunto = tipo.getAssunto(); 
    
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);
    
            mailSender.send(simpleMailMessage);
            notificacaoService.criarNotificacao(remetenteNotificacao, destinatario, mensagem);
    
            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
    
}
