package com.ifba.Gerenciador_TCC.tcc.repository;

import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TccRepository extends JpaRepository<Tcc, Long> {
}