package com.ifba.Gerenciador_TCC.tipocurso.interfaces;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;

import java.util.List;

public interface TipoCursoServiceApi {

    TipoCursoDTO criarTipoCurso(TipoCursoDTO tipoCursoDTO);

    TipoCursoDTO buscarTipoCursoPorId(Long id);

    List<TipoCursoDTO> listarTipoCursos();

    List<TipoCursoDTO> listarTipoCursosPorDescricao(String descricaoTipoCurso);

    void deletarTipoCurso(Long id);
}
