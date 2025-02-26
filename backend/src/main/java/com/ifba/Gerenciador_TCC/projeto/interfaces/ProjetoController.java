package com.ifba.Gerenciador_TCC.projeto.interfaces;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjetoController {

    ResponseEntity<List<Projeto>> listarProjetos();

    ResponseEntity<List<ProjetoDTO>> listarProjetosPorOrientador(Long idOrientador);

    ResponseEntity<Projeto> obterProjetoPorId(Long id);

    ResponseEntity<Projeto> criarProjeto(Projeto projeto);

    ResponseEntity<Projeto> atualizarProjeto(Projeto projeto);

    ResponseEntity<Void> deletarProjeto(Long id);
}
