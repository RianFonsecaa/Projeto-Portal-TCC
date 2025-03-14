package com.ifba.Gerenciador_TCC.projeto.interfaces;


import java.util.List;

import com.ifba.Gerenciador_TCC.projeto.domain.dto.InfoProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;

public interface ProjetoService {

    InfoProjetoDTO buscarInfoProjetoPorOrientando(Long idOrientando);

    List<ProjetoDTO> listarProjetosPorOrientador(Long idOrientador);

    List<InfoProjetoDTO> buscarInfoProjetoPorOrientador(Long idOrientador);

    Projeto findById(Long id);
}
