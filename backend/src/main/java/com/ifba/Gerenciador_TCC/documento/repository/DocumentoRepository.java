package com.ifba.Gerenciador_TCC.documento.repository;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoTarefaDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, UUID> {
    @Query("SELECT new com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoTarefaDTO(" +
            "d.id, d.titulo, d.escopoDocumento, d.caminhoArquivo, d.dataUpload, d.tamanho, d.tipoDocumento, t.id) " +
            "FROM DocumentoTarefa dt " +
            "JOIN dt.documento d " +
            "JOIN dt.tarefa t " +
            "WHERE t.id = :tarefaId")
    List<DocumentoTarefaDTO> findDocumentosByTarefaId(@Param("tarefaId") Long tarefaId);

    List<DocumentoEntity> findByProjetoId(Long projetoId);
}
