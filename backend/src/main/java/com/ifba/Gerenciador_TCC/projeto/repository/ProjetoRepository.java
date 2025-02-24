package com.ifba.Gerenciador_TCC.projeto.repository;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    
}
