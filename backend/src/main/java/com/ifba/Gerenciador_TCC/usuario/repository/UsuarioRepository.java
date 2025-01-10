package com.ifba.Gerenciador_TCC.usuario.repository;

import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
