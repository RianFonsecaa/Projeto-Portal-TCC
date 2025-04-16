package com.ifba.Gerenciador_TCC.documento.service;

import com.ifba.Gerenciador_TCC.documento.builder.DocumentoBuilder;
import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoTarefaDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoTarefa;
import com.ifba.Gerenciador_TCC.documento.interfaces.IDocumentoService;
import com.ifba.Gerenciador_TCC.documento.repository.DocumentoRepository;
import com.ifba.Gerenciador_TCC.documento.repository.DocumentoTarefaRepository;
import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentoService implements IDocumentoService {

    private final DocumentoRepository documentoRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private DocumentoTarefaRepository documentoTarefaRepository;
    @Autowired
    private ProjetoService projetoService;

    public DocumentoDTO salvar(DocumentoDTO dto) throws IOException {
        Projeto projeto = projetoService.findById(dto.getProjetoId());

        if (projeto == null){
            throw new NotFoundException("Projeto não encontrado");
        }

        DocumentoEntity entity = DocumentoBuilder.toEntity(dto, projeto);
    
        if (dto.getArquivo() != null && !dto.getArquivo().isEmpty()) {
            String urlArquivo = cloudinaryService.uploadFile(dto.getArquivo());
            entity.setCaminhoArquivo(urlArquivo); 
        }

        DocumentoEntity documentoEntity = documentoRepository.save(entity);
        salvarDocumentoTarefa(dto, documentoEntity);
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
                .orElseThrow(() -> new NotFoundException("Documento não encontrado"));
        return DocumentoBuilder.toDTO(entity);
    }

    @Override
    @Transactional
    public void deletar(UUID id) {
        Optional<DocumentoEntity> optionalDocumentoEntity = documentoRepository.findById(id);
        documentoTarefaRepository.deleteByDocumento(optionalDocumentoEntity.get());
        documentoRepository.deleteById(id);
    }

    @Override
    public void salvarDocumentoTarefa(DocumentoDTO dto, DocumentoEntity documentoEntity) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(dto.getTarefaId());
        if (!tarefaOptional.isPresent()){
            throw new NotFoundException("Tarefa não encontrado");
        }
        Tarefa tarefa = tarefaOptional.get();
        documentoTarefaRepository.save(DocumentoTarefa.builder()
                .documento(documentoEntity)
                .tarefa(tarefa)
                .build());
    }

    @Override
    public List<DocumentoTarefaDTO> getDocumentoByTarefa(Long id){
        List<DocumentoTarefaDTO> documentoTarefaDTOs = documentoRepository.findDocumentosByTarefaId(id);
        if (documentoTarefaDTOs == null){
            throw new NotFoundException("Documentos vinvulados a essa tarefa não encontrados");
        }
        return documentoTarefaDTOs;
    };
    @Override
    public List<DocumentoDTO> getDocumentoByProjeto(Long id){
        List<DocumentoEntity> documentoEntities = documentoRepository.findByProjetoId(id);
        if (documentoEntities == null){
            throw new NotFoundException("Documentos vinvulados a esse projeto não encontrados");
        }
        return documentoEntities.stream()
                .map(DocumentoBuilder::toDTO)
                .collect(Collectors.toList());
    }
}
