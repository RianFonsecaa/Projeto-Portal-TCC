package com.ifba.Gerenciador_TCC.documento.repository;

import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentoTarefaRepository extends JpaRepository<DocumentoTarefa, UUID> {
}
