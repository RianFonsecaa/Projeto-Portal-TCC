package com.ifba.Gerenciador_TCC.tipousuario.interfaces;

import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;

import java.util.List;

public interface TipoUsuarioServiceApi {

    TipoUsuarioDTO criarTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);

    TipoUsuarioDTO buscarTipoUsuarioPorId(Long id);

    List<TipoUsuarioDTO> listarTipoUsuarios();

    List<TipoUsuarioDTO> listarTipoUsuariosPorDescricao(String descricao);

    void deletarTipoUsuario(Long id);
}
