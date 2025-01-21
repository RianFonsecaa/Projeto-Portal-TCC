package com.ifba.Gerenciador_TCC.tcc.service;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;
import com.ifba.Gerenciador_TCC.tcc.mapper.TccMapper;
import com.ifba.Gerenciador_TCC.tcc.repository.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TccService implements TccServiceApi {

    @Autowired
    private TccRepository tccRepository;

    @Autowired
    private TccMapper tccMapper;

    @Override
    public TccDTO criarTcc(TccDTO tccDTO) {
        Tcc tcc = tccMapper.dtoToTcc(tccDTO);
        Tcc tccSalvo = tccRepository.save(tcc);
        return tccMapper.tccToDto(tccSalvo);
    }

    @Override
    public TccDTO buscarTccPorId(Long id) {
        Tcc tcc = tccRepository.findById(id).orElseThrow(() -> new RuntimeException("TCC não encontrado"));
        return tccMapper.tccToDto(tcc);
    }

    @Override
    public List<TccDTO> listarTccs() {
        List<Tcc> tccs = tccRepository.findAll();
        return tccs.stream().map(tccMapper::tccToDto).collect(Collectors.toList());
    }

    @Override
    public TccDTO atualizarTcc(Long id, TccDTO tccDTO) {
        Tcc tccExistente = tccRepository.findById(id).orElseThrow(() -> new RuntimeException("TCC não encontrado"));
        Tcc tccAtualizado = tccMapper.dtoToTcc(tccDTO);
        tccAtualizado.setId(tccExistente.getId());
        Tcc tccSalvo = tccRepository.save(tccAtualizado);
        return tccMapper.tccToDto(tccSalvo);
    }

    @Override
    public void deletarTcc(Long id) {
        Tcc tcc = tccRepository.findById(id).orElseThrow(() -> new RuntimeException("TCC não encontrado"));
        tccRepository.delete(tcc);
    }
}
