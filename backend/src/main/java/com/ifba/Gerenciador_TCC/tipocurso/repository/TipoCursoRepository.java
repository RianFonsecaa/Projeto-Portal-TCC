package com.ifba.Gerenciador_TCC.tipocurso.repository;

import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso, Long> {

    List<TipoCurso> findByDescricaoTipoCurso(String descricaoTipoCurso);
}
