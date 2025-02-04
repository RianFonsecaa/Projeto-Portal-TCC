package com.ifba.Gerenciador_TCC.quadrodemandas.repository;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.entity.QuadroDemandas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadroDemandasRepository extends JpaRepository<QuadroDemandas, Long> {
}
