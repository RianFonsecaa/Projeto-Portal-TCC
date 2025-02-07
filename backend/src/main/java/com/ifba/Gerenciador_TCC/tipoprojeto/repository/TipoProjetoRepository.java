package com.ifba.Gerenciador_TCC.tipoprojeto.repository;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity.TipoProjeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProjetoRepository extends JpaRepository<TipoProjeto, Long> {

    List<TipoProjeto> findByDescricaoTipoProjeto(String descricaoTipoProjeto);
}
