package com.ifba.Gerenciador_TCC.usuario.interfaces;

import java.util.List;
import java.util.Optional;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;

public interface UsuarioServiceApi {
    Usuario create(UsuarioDTO usuarioDTO);

    Usuario update(UsuarioDTO usuarioDTO);

    void delete(Long id);

    List<Usuario> findAll();

    Usuario findById(Long id);

    Optional<Usuario> findByEmail(String email);

}
