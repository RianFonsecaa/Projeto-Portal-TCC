package com.ifba.Gerenciador_TCC.usuario.domain.dto;

import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;

import jakarta.persistence.Column;
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


    private String username;

    @NotNull(message = "Senha não pode ser vazia")
    private String senha;


    private String nome;

    @NotNull(message = "Email não pode ser vazio")
    private String email;

}
