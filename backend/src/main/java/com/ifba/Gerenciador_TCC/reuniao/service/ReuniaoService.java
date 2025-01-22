package com.ifba.Gerenciador_TCC.reuniao.service;

import com.ifba.Gerenciador_TCC.reuniao.domain.dto.ReuniaoDTO;
import com.ifba.Gerenciador_TCC.reuniao.domain.entity.Reuniao;
import com.ifba.Gerenciador_TCC.reuniao.domain.mapper.ReuniaoMapper;
import com.ifba.Gerenciador_TCC.reuniao.domain.repository.ReuniaoRepository;
import com.ifba.Gerenciador_TCC.reuniao.interfaces.ReuniaoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReuniaoService implements ReuniaoServiceApi {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private ReuniaoMapper reuniaoMapper;

    @Override
    public ReuniaoDTO criarReuniao(ReuniaoDTO reuniaoDTO) {
        Reuniao reuniao = reuniaoMapper.dtoToReuniao(reuniaoDTO);
        Reuniao reuniaoSalvo = reuniaoRepository.save(reuniao);
        return reuniaoMapper.reuniaoToDTO(reuniaoSalvo);
    }

    @Override
    public ReuniaoDTO buscarReuniaoPorId(Long id) {
        Reuniao reuniao = reuniaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reuniao não encontrado com o ID: " + id));
        return reuniaoMapper.reuniaoToDTO(reuniao);
    }

    @Override
    public List<ReuniaoDTO> listarReunioes() {
        List<Reuniao> reunioes = reuniaoRepository.findAll();
        return reunioes.stream()
                .map(reuniaoMapper::reuniaoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReuniaoDTO> listarReunioesPorUsuario(Long idUsuario) {
        List<Reuniao> reunioes = reuniaoRepository.findByIdUsuario(idUsuario);
        return reunioes.stream()
                .map(reuniaoMapper::reuniaoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReuniaoDTO> listarReunioesPorNome(String nomeReuniao) {
        List<Reuniao> reunioes = reuniaoRepository.findByNomeReuniao(nomeReuniao);
        return reunioes.stream()
                .map(reuniaoMapper::reuniaoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReuniaoDTO> listarReunioesPorData(LocalDate dataReuniao) {
        List<Reuniao> reunioes = reuniaoRepository.findByDataReuniao(dataReuniao);
        return reunioes.stream()
                .map(reuniaoMapper::reuniaoToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarReuniao(Long id) {
        if (!reuniaoRepository.existsById(id)) {
            throw new RuntimeException("Reuniao não encontrada com o ID: " + id);
        }
        reuniaoRepository.deleteById(id);
    }
}
