package com.ifba.Gerenciador_TCC.usuario.domain.entity;

import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "orientando")
public class Orientando extends Usuario {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCurso tipoCurso;
}
