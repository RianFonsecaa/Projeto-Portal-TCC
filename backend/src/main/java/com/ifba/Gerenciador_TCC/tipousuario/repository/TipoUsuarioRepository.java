package com.ifba.Gerenciador_TCC.tipousuario.repository;

import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

    List<TipoUsuario> findByDescricaoTipoUsuario(String descricao);
}
