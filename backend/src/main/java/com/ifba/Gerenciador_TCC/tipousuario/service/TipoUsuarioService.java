package com.ifba.Gerenciador_TCC.tipousuario.service;

import com.ifba.Gerenciador_TCC.tipousuario.domain.dto.TipoUsuarioDTO;
import com.ifba.Gerenciador_TCC.tipousuario.domain.entity.TipoUsuario;
import com.ifba.Gerenciador_TCC.tipousuario.interfaces.TipoUsuarioServiceApi;
import com.ifba.Gerenciador_TCC.tipousuario.mapper.TipoUsuarioMapper;
import com.ifba.Gerenciador_TCC.tipousuario.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoUsuarioService implements TipoUsuarioServiceApi {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private TipoUsuarioMapper tipoUsuarioMapper;

    @Override
    public TipoUsuarioDTO criarTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = tipoUsuarioMapper.dtoToTipoUsuario(tipoUsuarioDTO);
        TipoUsuario tipoUsuarioSalvo = tipoUsuarioRepository.save(tipoUsuario);
        return tipoUsuarioMapper.tipoUsuarioToDTO(tipoUsuarioSalvo);
    }

    @Override
    public TipoUsuarioDTO buscarTipoUsuarioPorId(Long id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoUsuario não encontrado com o ID: " + id));
        return tipoUsuarioMapper.tipoUsuarioToDTO(tipoUsuario);
    }

    @Override
    public List<TipoUsuarioDTO> listarTipoUsuarios() {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioRepository.findAll();
        return tipoUsuarios.stream()
                .map(tipoUsuarioMapper::tipoUsuarioToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoUsuarioDTO> listarTipoUsuariosPorDescricao(String descricao) {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioRepository.findByDescricaoTipoUsuario(descricao);
        return tipoUsuarios.stream()
                .map(tipoUsuarioMapper::tipoUsuarioToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarTipoUsuario(Long id) {
        if (!tipoUsuarioRepository.existsById(id)) {
            throw new RuntimeException("TipoUsuario não encontrada com o ID: " + id);
        }
        tipoUsuarioRepository.deleteById(id);
    }
}