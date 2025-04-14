package com.ifba.Gerenciador_TCC.documento.interfaces;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoTarefaDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;

import java.util.List;
import java.util.UUID;
import java.io.IOException;

public interface IDocumentoService {
    DocumentoDTO salvar(DocumentoDTO dto) throws IOException;
    List<DocumentoDTO> listar();
    DocumentoDTO buscarPorId(UUID id);
    void deletar(UUID id);
    void salvarDocumentoTarefa(DocumentoDTO dto, DocumentoEntity documentoEntity);
    public List<DocumentoTarefaDTO> getDocumentoByTarefa(Long id);

    public List<DocumentoDTO> getDocumentoByProjeto(Long id);
}
