package com.ifba.Gerenciador_TCC.tipousuario.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipousuario")
@Builder
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    @NotEmpty(message = "O campo 'descrição' não pode estar vazio.")
    private String descricao;
}