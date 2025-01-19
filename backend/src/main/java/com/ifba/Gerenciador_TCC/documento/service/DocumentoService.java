package com.ifba.Gerenciador_TCC.documento.service;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.Documento;
import com.ifba.Gerenciador_TCC.documento.domain.mapper.DocumentoMapper;
import com.ifba.Gerenciador_TCC.documento.domain.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoService implements DocumentoServiceApi {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private DocumentoMapper documentoMapper;

    @Override
    public DocumentoDTO criarDocumento(DocumentoDTO documentoDTO) {
        Documento documento = documentoMapper.dtoToDocumento(documentoDTO);
        Documento documentoSalvo = documentoRepository.save(documento);
        return documentoMapper.documentoToDTO(documentoSalvo);
    }

    @Override
    public DocumentoDTO buscarDocumentoPorId(Long id) {
        Documento documento = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com o ID: " + id));
        return documentoMapper.documentoToDTO(documento);
    }

    @Override
    public List<DocumentoDTO> listarDocumentos() {
        List<Documento> documentos = documentoRepository.findAll();
        return documentos.stream()
                .map(documentoMapper::documentoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoDTO> listarDocumentosPorProjeto(Long idProjeto) {
        List<Documento> documentos = documentoRepository.findByIdProjeto(idProjeto);
        return documentos.stream()
                .map(documentoMapper::documentoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoDTO> listarDocumentosPorTipo(String tipoDocumento) {
        List<Documento> documentos = documentoRepository.findByTipoDocumento(tipoDocumento);
        return documentos.stream()
                .map(documentoMapper::documentoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoDTO> listarDocumentosPorDataEnvio(LocalDate dataEnvio) {
        List<Documento> documentos = documentoRepository.findByDataEnvioAfter(dataEnvio);
        return documentos.stream()
                .map(documentoMapper::documentoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarDocumento(Long id) {
        if (!documentoRepository.existsById(id)) {
            throw new RuntimeException("Documento não encontrado com o ID: " + id);
        }
        documentoRepository.deleteById(id);
    }
}
