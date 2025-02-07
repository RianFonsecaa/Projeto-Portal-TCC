package com.ifba.Gerenciador_TCC.usuario.domain.dto;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;

    @NotNull(message = "Username não pode estar vazio")
    private String username;

    @NotNull(message = "Senha não pode estar vazia")
    private String senha;

    @NotNull(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Email não pode estar vazio")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotNull
    @JoinColumn
    private TipoUsuarioDTO tipoUsuario;

    @JoinColumn
    private TipoCursoDTO tipoCurso;

}
