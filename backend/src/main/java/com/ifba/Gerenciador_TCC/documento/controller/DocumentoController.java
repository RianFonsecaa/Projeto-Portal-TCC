package com.ifba.Gerenciador_TCC.documento.controller;

import com.ifba.Gerenciador_TCC.documento.api.DocumentoControllerApi;
import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController implements DocumentoControllerApi {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<DocumentoDTO> criarDocumento(@RequestBody DocumentoDTO documentoDTO) {
        DocumentoDTO documentoCriado = documentoService.criarDocumento(documentoDTO);
        return ResponseEntity.ok(documentoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTO> buscarDocumentoPorId(@PathVariable Long id) {
        DocumentoDTO documento = documentoService.buscarDocumentoPorId(id);
        return ResponseEntity.ok(documento);
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDTO>> listarDocumentos() {
        List<DocumentoDTO> documentos = documentoService.listarDocumentos();
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/projeto/{idProjeto}")
    public ResponseEntity<List<DocumentoDTO>> listarDocumentosPorProjeto(@PathVariable Long idProjeto) {
        List<DocumentoDTO> documentos = documentoService.listarDocumentosPorProjeto(idProjeto);
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<DocumentoDTO>> listarDocumentosPorTipo(@RequestParam String tipoDocumento) {
        List<DocumentoDTO> documentos = documentoService.listarDocumentosPorTipo(tipoDocumento);
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/data")
    public ResponseEntity<List<DocumentoDTO>> listarDocumentosPorDataEnvio(@RequestParam LocalDate dataEnvio) {
        List<DocumentoDTO> documentos = documentoService.listarDocumentosPorDataEnvio(dataEnvio);
        return ResponseEntity.ok(documentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDocumento(@PathVariable Long id) {
        documentoService.deletarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
