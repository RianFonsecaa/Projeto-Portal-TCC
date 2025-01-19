package com.ifba.Gerenciador_TCC.documento.service;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;

import java.time.LocalDate;
import java.util.List;

public interface DocumentoServiceApi {

    DocumentoDTO criarDocumento(DocumentoDTO documentoDTO);

    DocumentoDTO buscarDocumentoPorId(Long id);

    List<DocumentoDTO> listarDocumentos();

    List<DocumentoDTO> listarDocumentosPorProjeto(Long idProjeto);

    List<DocumentoDTO> listarDocumentosPorTipo(String tipoDocumento);

    List<DocumentoDTO> listarDocumentosPorDataEnvio(LocalDate dataEnvio);

    void deletarDocumento(Long id);
}
