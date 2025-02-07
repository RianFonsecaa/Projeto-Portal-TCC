package com.ifba.Gerenciador_TCC.tipoprojeto.interfaces;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;

import java.util.List;

public interface TipoProjetoServiceApi {

    TipoProjetoDTO criarTipoProjeto(TipoProjetoDTO tipoProjetoDTO);

    TipoProjetoDTO buscarTipoProjetoPorId(Long id);

    List<TipoProjetoDTO> listarTipoProjetos();

    List<TipoProjetoDTO> listarTipoProjetosPorDescricao(String descricaoTipoProjeto);

    void deletarTipoProjeto(Long id);
}
