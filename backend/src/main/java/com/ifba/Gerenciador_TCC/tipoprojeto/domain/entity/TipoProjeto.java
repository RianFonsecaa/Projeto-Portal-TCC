package com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity;


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
@Table(name = "tipoprojeto")
@Builder
public class TipoProjeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    @NotEmpty(message = "O campo 'descrição' não pode estar vazio.")
    private String descricaoTipoProjeto;
}