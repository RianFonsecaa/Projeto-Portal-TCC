package com.ifba.Gerenciador_TCC.tcc.service;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import java.util.List;

public interface TccServiceApi {

    TccDTO criarTcc(TccDTO tccDTO);

    TccDTO buscarTccPorId(Long id);

    List<TccDTO> listarTccs();

    TccDTO atualizarTcc(Long id, TccDTO tccDTO);

    void deletarTcc(Long id);
}
