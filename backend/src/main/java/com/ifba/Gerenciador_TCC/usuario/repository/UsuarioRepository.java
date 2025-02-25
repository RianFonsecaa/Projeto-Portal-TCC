package com.ifba.Gerenciador_TCC.usuario.repository;

import com.ifba.Gerenciador_TCC.tipoenum.TipoUsuario;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario);

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH Orientador o ON u.id = o.id LEFT JOIN FETCH Orientando or ON u.id = or.id WHERE u.id = :id")
    Optional<Usuario> findByIdWithDetails(@Param("id") long id);
}