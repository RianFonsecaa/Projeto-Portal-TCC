package com.ifba.Gerenciador_TCC.documento.repository;

import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, UUID> {
}
