package com.ifba.Gerenciador_TCC.documento.controller;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoTarefaDTO;
import com.ifba.Gerenciador_TCC.documento.domain.entity.DocumentoEntity;
import com.ifba.Gerenciador_TCC.documento.domain.enums.EscopoDocumentoEnum;
import com.ifba.Gerenciador_TCC.documento.interfaces.IDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoController {

    private final IDocumentoService documentoService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<DocumentoDTO> uploadDocumento(
    @RequestParam("titulo") String titulo,
    @RequestParam("escopo") EscopoDocumentoEnum escopo,
    @RequestParam("tipo") String tipo,
    @RequestParam("tarefaid") Long tarefaid,
    @RequestParam("projetoid") Long projetoid,
    @RequestParam("arquivo") MultipartFile file

    ) throws IOException {
        
    DocumentoDTO dto = new DocumentoDTO();
    dto.setTitulo(titulo);
    dto.setEscopoDocumento(escopo);
    dto.setArquivo(file);
    dto.setTipoDocumento(tipo);
    dto.setTarefaId(tarefaid);
    dto.setProjetoId(projetoid);
    dto.setTamanho(Math.round((file.getSize() / 1024.0) * 100.0) / 100.0);
    
    DocumentoDTO salvo = documentoService.salvar(dto);
    return ResponseEntity.ok(salvo);
    }


    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> listar() {
        return ResponseEntity.ok(documentoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(documentoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        documentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tarefa/{id}")
    public ResponseEntity<List<DocumentoTarefaDTO>> getDocumentoByTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.getDocumentoByTarefa(id));
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<List<DocumentoDTO>> getDocumentoByProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.getDocumentoByProjeto(id));
    }

}
