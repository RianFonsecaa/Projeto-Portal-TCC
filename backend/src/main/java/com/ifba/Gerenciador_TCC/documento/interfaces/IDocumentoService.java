package com.ifba.Gerenciador_TCC.documento.interfaces;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;

import java.util.List;
import java.util.UUID;
import java.io.IOException;

public interface IDocumentoService {
    DocumentoDTO salvar(DocumentoDTO dto) throws IOException;
    List<DocumentoDTO> listar();
    DocumentoDTO buscarPorId(UUID id);
    void deletar(UUID id);
}
