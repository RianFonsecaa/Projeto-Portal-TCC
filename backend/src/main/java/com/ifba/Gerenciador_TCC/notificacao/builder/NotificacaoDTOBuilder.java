package com.ifba.Gerenciador_TCC.notificacao.builder;

import com.ifba.Gerenciador_TCC.notificacao.domain.dto.NotificacaoDTO;
import com.ifba.Gerenciador_TCC.notificacao.domain.entity.Notificacao;

import java.util.Date;

public class NotificacaoDTOBuilder {
    
    public static Notificacao buildNotificacao(NotificacaoDTO notificacaoDTO) {
        return Notificacao.builder()
                .id(notificacaoDTO.getId())
                .remetente(notificacaoDTO.getRemetente())
                .mensagem(notificacaoDTO.getMensagem())
                .data(notificacaoDTO.getData() != null ? notificacaoDTO.getData() : new Date())
                .visualizado(notificacaoDTO.isVisualizado())
                .build();
    }

    public static NotificacaoDTO buildNotificacaoDTO(Notificacao notificacao) {
        return NotificacaoDTO.builder()
                .id(notificacao.getId())
                .remetente(notificacao.getRemetente())
                .mensagem(notificacao.getMensagem())
                .data(notificacao.getData())
                .visualizado(notificacao.isVisualizado())
                .build();
    }
}
