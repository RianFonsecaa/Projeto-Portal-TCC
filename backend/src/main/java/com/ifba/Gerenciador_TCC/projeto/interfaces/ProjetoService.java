package com.ifba.Gerenciador_TCC.projeto.interfaces;


import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<Projeto> listarProjetos();

    List<Projeto> listarProjetosPorOrientador(Long idOrientador);

    public List<ProjetoDTO> listarProjetosDTOPorOrientador(Long idOrientador);

    Projeto obterProjetoPorId(Long id);

    Projeto criarProjeto(Projeto projeto);

    Projeto atualizarProjeto(Projeto projeto);

    void deletarProjeto(Long id);

    Projeto findById(long projetoId);
}
