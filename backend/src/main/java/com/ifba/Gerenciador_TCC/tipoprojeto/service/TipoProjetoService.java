package com.ifba.Gerenciador_TCC.tipoprojeto.service;

import com.ifba.Gerenciador_TCC.tipoprojeto.domain.dto.TipoProjetoDTO;
import com.ifba.Gerenciador_TCC.tipoprojeto.domain.entity.TipoProjeto;
import com.ifba.Gerenciador_TCC.tipoprojeto.interfaces.TipoProjetoServiceApi;
import com.ifba.Gerenciador_TCC.tipoprojeto.mapper.TipoProjetoMapper;
import com.ifba.Gerenciador_TCC.tipoprojeto.repository.TipoProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoProjetoService implements TipoProjetoServiceApi {

    @Autowired
    private TipoProjetoRepository tipoProjetoRepository;

    @Autowired
    private TipoProjetoMapper tipoProjetoMapper;

    @Override
    public TipoProjetoDTO criarTipoProjeto(TipoProjetoDTO tipoProjetoDTO) {
        TipoProjeto tipoProjeto = tipoProjetoMapper.dtoToTipoProjeto(tipoProjetoDTO);
        TipoProjeto tipoProjetoSalvo = tipoProjetoRepository.save(tipoProjeto);
        return tipoProjetoMapper.tipoProjetoToDTO(tipoProjetoSalvo);
    }

    @Override
    public TipoProjetoDTO buscarTipoProjetoPorId(Long id) {
        TipoProjeto tipoProjeto = tipoProjetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoProjeto não encontrado com o ID: " + id));
        return tipoProjetoMapper.tipoProjetoToDTO(tipoProjeto);
    }

    @Override
    public List<TipoProjetoDTO> listarTipoProjetos() {
        List<TipoProjeto> tipoProjetos = tipoProjetoRepository.findAll();
        return tipoProjetos.stream()
                .map(tipoProjetoMapper::tipoProjetoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoProjetoDTO> listarTipoProjetosPorDescricao(String descricao) {
        List<TipoProjeto> tipoProjetos = tipoProjetoRepository.findByDescricaoTipoProjeto(descricao);
        return tipoProjetos.stream()
                .map(tipoProjetoMapper::tipoProjetoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarTipoProjeto(Long id) {
        if (!tipoProjetoRepository.existsById(id)) {
            throw new RuntimeException("TipoProjeto não encontrada com o ID: " + id);
        }
        tipoProjetoRepository.deleteById(id);
    }
}