package com.ifba.Gerenciador_TCC.notificacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
 
    @Value("${spring.mail.username}")
    private String remetente;

    public String enviarEmailTexto(String destinatario, String assunto, String mensagem) {
        try {
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
}
