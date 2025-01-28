package com.ifba.Gerenciador_TCC.documento.repository;

import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("SELECT d FROM Documento d WHERE d.projetoId.id = :idProjeto")
    List<Documento> findByIdProjetoId(@Param("idProjeto") Long idProjeto);

    List<Documento> findByTipoDocumento(String tipoDocumento);

    List<Documento> findByDataEnvioAfter(LocalDate dataEnvio);
}
