package com.ifba.Gerenciador_TCC.documento.repository;

import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoTarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentoTarefaRepository extends JpaRepository<DocumentoTarefa, UUID> {
    void deleteByDocumento(DocumentoEntity documentoEntity);
}
