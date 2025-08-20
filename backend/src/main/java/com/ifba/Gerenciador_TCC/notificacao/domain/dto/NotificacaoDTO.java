package com.ifba.Gerenciador_TCC.notificacao.domain.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder 
public class NotificacaoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String remetente;

    private String destinatario;

    @Column(columnDefinition = "TEXT") 
    private String mensagem;

    private String assunto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private boolean visualizado;
}