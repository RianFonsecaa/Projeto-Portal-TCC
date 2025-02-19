package com.ifba.Gerenciador_TCC.notificacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;
import com.ifba.Gerenciador_TCC.notificacao.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }
    
    public Notificacao buscarPorId(Long id) {
        Optional<Notificacao> optional = notificacaoRepository.findById(id);
        return optional.orElse(null);
    }
}