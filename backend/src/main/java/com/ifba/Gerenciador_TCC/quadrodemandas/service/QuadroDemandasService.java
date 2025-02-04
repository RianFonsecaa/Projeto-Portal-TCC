package com.ifba.Gerenciador_TCC.quadrodemandas.service;

import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.entity.QuadroDemandas;
import com.ifba.Gerenciador_TCC.quadrodemandas.interfaces.QuadroDemandasServiceApi;
import com.ifba.Gerenciador_TCC.quadrodemandas.mapper.QuadroDemandasMapper;
import com.ifba.Gerenciador_TCC.quadrodemandas.repository.QuadroDemandasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuadroDemandasService implements QuadroDemandasServiceApi {

    @Autowired
    private QuadroDemandasRepository quadroDemandasRepository;

    @Autowired
    private QuadroDemandasMapper quadroDemandasMapper;

    @Override
    public QuadroDemandasDTO criarQuadroDemandas(QuadroDemandasDTO quadroDemandasDTO) {
        QuadroDemandas quadroDemandas = quadroDemandasMapper.dtoToQuadroDemandas(quadroDemandasDTO);
        QuadroDemandas salvo = quadroDemandasRepository.save(quadroDemandas);
        return quadroDemandasMapper.quadroDemandasToDTO(salvo);
    }

    @Override
    public QuadroDemandasDTO buscarQuadroDemandasPorId(Long id) {
        QuadroDemandas quadroDemandas = quadroDemandasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quadro de Demandas não encontrado com o ID: " + id));
        return quadroDemandasMapper.quadroDemandasToDTO(quadroDemandas);
    }

    @Override
    public List<QuadroDemandasDTO> listarQuadrosDemandas() {
        return quadroDemandasRepository.findAll().stream()
                .map(quadroDemandasMapper::quadroDemandasToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarQuadroDemandas(Long id) {
        if (!quadroDemandasRepository.existsById(id)) {
            throw new RuntimeException("Quadro de Demandas não encontrado com o ID: " + id);
        }
        quadroDemandasRepository.deleteById(id);
    }
}