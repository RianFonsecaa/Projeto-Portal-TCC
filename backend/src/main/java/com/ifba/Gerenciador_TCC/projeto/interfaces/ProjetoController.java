package com.ifba.Gerenciador_TCC.projeto.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.InfoProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;

public interface ProjetoController {

    ResponseEntity<InfoProjetoDTO> buscarInfoProjetoPorOrientando(Long idOrientando);

    ResponseEntity<List<ProjetoDTO>> listarProjetosPorOrientador(Long idOrientador);

    ResponseEntity<List<InfoProjetoDTO>> buscarInfoProjetoPorOrientador(Long idOrientador);

    ResponseEntity<Projeto> findById(Long id);


}
