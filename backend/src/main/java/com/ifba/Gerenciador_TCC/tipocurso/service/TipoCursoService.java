package com.ifba.Gerenciador_TCC.tipocurso.service;

import com.ifba.Gerenciador_TCC.tipocurso.domain.dto.TipoCursoDTO;
import com.ifba.Gerenciador_TCC.tipocurso.domain.entity.TipoCurso;
import com.ifba.Gerenciador_TCC.tipocurso.interfaces.TipoCursoServiceApi;
import com.ifba.Gerenciador_TCC.tipocurso.mapper.TipoCursoMapper;
import com.ifba.Gerenciador_TCC.tipocurso.repository.TipoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoCursoService implements TipoCursoServiceApi {

    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    @Autowired
    private TipoCursoMapper tipoCursoMapper;

    @Override
    public TipoCursoDTO criarTipoCurso(TipoCursoDTO tipoCursoDTO) {
        TipoCurso tipoCurso = tipoCursoMapper.dtoToTipoCurso(tipoCursoDTO);
        TipoCurso tipoCursoSalvo = tipoCursoRepository.save(tipoCurso);
        return tipoCursoMapper.tipoCursoToDTO(tipoCursoSalvo);
    }

    @Override
    public TipoCursoDTO buscarTipoCursoPorId(Long id) {
        TipoCurso tipoCurso = tipoCursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCurso não encontrado com o ID: " + id));
        return tipoCursoMapper.tipoCursoToDTO(tipoCurso);
    }

    @Override
    public List<TipoCursoDTO> listarTipoCursos() {
        List<TipoCurso> tipoCursos = tipoCursoRepository.findAll();
        return tipoCursos.stream()
                .map(tipoCursoMapper::tipoCursoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoCursoDTO> listarTipoCursosPorDescricao(String descricaoTipoCurso) {
        List<TipoCurso> tipoCursos = tipoCursoRepository.findByDescricaoTipoCurso(descricaoTipoCurso);
        return tipoCursos.stream()
                .map(tipoCursoMapper::tipoCursoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarTipoCurso(Long id) {
        if (!tipoCursoRepository.existsById(id)) {
            throw new RuntimeException("TipoCurso não encontrada com o ID: " + id);
        }
        tipoCursoRepository.deleteById(id);
    }
}