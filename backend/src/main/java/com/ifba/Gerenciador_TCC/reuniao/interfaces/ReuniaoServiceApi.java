package com.ifba.Gerenciador_TCC.reuniao.interfaces;

import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReuniaoServiceApi {

    ReuniaoDTO criarReuniao(ReuniaoDTO reuniaoDTO);

    ReuniaoDTO buscarReuniaoPorId(Long id);

    List<ReuniaoDTO> listarReunioes();

    List<ReuniaoDTO> listarReunioesPorNome(String nomeReuniao);

    List<ReuniaoDTO> listarReunioesPorUsuario(Long idUsuario);

    List<ReuniaoDTO> listarReunioesPorData(LocalDate dataReuniao);

    void deletarReuniao(Long id);
}
