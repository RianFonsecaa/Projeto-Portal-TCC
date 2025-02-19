package com.ifba.Gerenciador_TCC.notificacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;
import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
 

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private NotificacaoService notificacaoService;


    public String enviarEmailTexto(String destinatario, String assunto, String mensagem, String remetenteNotificacao) {
        try {
            // Envio do e-mail
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);

            mailSender.send(simpleMailMessage);
            // vai criar uma notificação com o remetente como parâmetro, após enviar o email.
            Notificacao notificacao = new Notificacao();
            notificacao.setRemetente(remetenteNotificacao);
            notificacao.setMensagem(mensagem);
            notificacao.setData(new Date());
            notificacao.setVisualizado(false);
            
            notificacaoService.salvarNotificacao(notificacao);

            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
    
    public String enviarEmailApenas(String destinatario, String assunto, String mensagem) {
        try {
            // Envio do e-mail
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(mensagem);

            mailSender.send(simpleMailMessage);

            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
    
    public String getRemetente() {
        return remetente;
    }

}
