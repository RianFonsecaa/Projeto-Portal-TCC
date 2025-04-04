package com.ifba.Gerenciador_TCC.documento.controller;

import com.ifba.Gerenciador_TCC.documento.domain.dto.DocumentoDTO;
import com.ifba.Gerenciador_TCC.documento.domain.enums.TipoDocumentoEnum;
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
public class DocumentoController {

    private final IDocumentoService documentoService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<DocumentoDTO> uploadDocumento(
    @RequestParam("titulo") String titulo,
    @RequestParam("tipo") TipoDocumentoEnum tipo,
    @RequestParam(value = "codigoTarefa", required = false) Long codigoTarefa,
    @RequestParam("arquivo") MultipartFile file
    ) throws IOException {
    DocumentoDTO dto = new DocumentoDTO();
    dto.setTitulo(titulo);
    dto.setTipoDocumento(tipo);
    dto.setArquivo(file);
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

    

}
