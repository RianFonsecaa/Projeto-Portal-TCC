package com.ifba.Gerenciador_TCC.usuario.interfaces;

import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;

import java.util.List;

public interface UsuarioServiceApi {
    Usuario create(UsuarioDTO usuarioDTO);

    Usuario update(UsuarioDTO usuarioDTO);

    void delete(long id);

    List<Usuario> findAll();

    Usuario findById(long id);

}
