package com.ifba.Gerenciador_TCC.usuario.domain.entity;

import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import com.ifba.Gerenciador_TCC.tipoenum.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orientando")
public class Orientando extends Usuario {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCurso tipoCurso;
}
