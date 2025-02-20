package com.ifba.Gerenciador_TCC.email.service;

import com.ifba.Gerenciador_TCC.email.tipoenum.TipoMensagem;
import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;
import com.ifba.Gerenciador_TCC.notificacao.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificacaoService notificacaoService;

    @Value("${spring.mail.username}")
    private String remetente;

   
    public String enviarEmailComTemplate(String destinatario, String assunto, TipoMensagem tipo, String conteudo, String remetenteNotificacao) {
        try {
            
            String mensagem = String.format(tipo.getTemplate(), conteudo);
            mensagem += "\n\nAtenciosamente,\n" + remetenteNotificacao;
    
        
            enviarEmail(destinatario, assunto, mensagem);
    
          
            String mensagemNotificacao = mensagem.replace("\n", " ");
    
        
            Notificacao notificacao = new Notificacao();
            notificacao.setRemetente(remetenteNotificacao);
            notificacao.setMensagem(mensagemNotificacao);
            notificacao.setData(new Date());
            notificacao.setVisualizado(false);
            notificacaoService.salvarNotificacao(notificacao);
    
            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
    
    
    public void enviarEmail(String destinatario, String assunto, String mensagem) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText(mensagem);
        mailSender.send(simpleMailMessage);
    }

    public String getRemetente() {
        return remetente;
    }
}
