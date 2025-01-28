package com.ifba.Gerenciador_TCC.usuario.repository;

import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}