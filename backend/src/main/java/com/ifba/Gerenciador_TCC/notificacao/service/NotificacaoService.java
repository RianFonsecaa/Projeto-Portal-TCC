package com.ifba.Gerenciador_TCC.notificacao.service;

import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;
import com.ifba.Gerenciador_TCC.notificacao.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao buscarPorId(Long id) {
        return notificacaoRepository.findById(id).orElse(null);
    }

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoesPorUsuario(String emailUsuario) {
        return notificacaoRepository.findByDestinatario(emailUsuario);
    }

    public void criarNotificacao(String remetente, String destinatario, String assunto, String mensagem) {
        Notificacao notificacao = Notificacao.builder()
                .remetente(remetente)
                .destinatario(destinatario)
                .assunto(assunto)
                .mensagem(mensagem)
                .data(new Date())
                .visualizado(false)
                .build();
        notificacaoRepository.save(notificacao);
    }


    public Long contarNaoVisualizadasPorUsuario(String emailUsuario) {
        return notificacaoRepository.countByDestinatarioAndVisualizadoFalse(emailUsuario);
    }
}