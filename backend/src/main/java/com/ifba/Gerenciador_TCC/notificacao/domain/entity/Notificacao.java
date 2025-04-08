package com.ifba.Gerenciador_TCC.notificacao.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "notificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder 
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 400)
    private String remetente;

    @Column(length = 400)
    private String destinatario;

    @Column(columnDefinition = "TEXT") 
    private String mensagem;

    @Column(length = 500)
    private String assunto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private boolean visualizado;
}