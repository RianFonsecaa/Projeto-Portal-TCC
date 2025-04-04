package com.ifba.Gerenciador_TCC.documento.service;

import com.ifba.Gerenciador_TCC.documento.builder.DocumentoBuilder;
import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.documento.interfaces.IDocumentoService;
import com.ifba.Gerenciador_TCC.documento.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import com.ifba.Gerenciador_TCC.documento.service.CloudinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentoService implements IDocumentoService {

    private final DocumentoRepository documentoRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    public DocumentoDTO salvar(DocumentoDTO dto) throws IOException {
        DocumentoEntity entity = DocumentoBuilder.toEntity(dto);
    
        if (dto.getArquivo() != null && !dto.getArquivo().isEmpty()) {
            String urlArquivo = cloudinaryService.uploadFile(dto.getArquivo());
            entity.setCaminhoArquivo(urlArquivo); 
        }
    
        documentoRepository.save(entity);
        return DocumentoBuilder.toDTO(entity);
    }
    @Override
    public List<DocumentoDTO> listar() {
        return documentoRepository.findAll().stream()
                .map(DocumentoBuilder::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentoDTO buscarPorId(UUID id) {
        DocumentoEntity entity = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));
        return DocumentoBuilder.toDTO(entity);
    }

    @Override
    public void deletar(UUID id) {
        documentoRepository.deleteById(id);
    }
}
