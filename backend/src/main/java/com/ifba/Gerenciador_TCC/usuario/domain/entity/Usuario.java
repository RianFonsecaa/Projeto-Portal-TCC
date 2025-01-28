package com.ifba.Gerenciador_TCC.usuario.domain.entity;

import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "O campo 'username' não pode estar vazio.")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'senha' não pode estar vazio.")
    private String senha;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'nome' não pode estar vazio.")
    private String nome;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "O campo 'email' não pode estar vazio.")
    private String email;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", nullable = false)
    private TipoUsuario tipoUsuario;

}
