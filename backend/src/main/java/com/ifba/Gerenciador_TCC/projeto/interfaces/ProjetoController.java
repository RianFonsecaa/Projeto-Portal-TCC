package com.ifba.Gerenciador_TCC.projeto.interfaces;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ProjetoController {

    ResponseEntity<List<Projeto>> listarProjetos();

    ResponseEntity<Projeto> obterProjetoPorId(Long id);

    ResponseEntity<Projeto> criarProjeto(Projeto projeto);

    ResponseEntity<Projeto> atualizarProjeto(Long id, Projeto projeto);

    ResponseEntity<Void> deletarProjeto(Long id);
}
