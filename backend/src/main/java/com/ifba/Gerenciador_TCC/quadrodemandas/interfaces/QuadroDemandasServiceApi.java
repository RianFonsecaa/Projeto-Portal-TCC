package com.ifba.Gerenciador_TCC.quadrodemandas.interfaces;


import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import java.util.List;
public interface QuadroDemandasServiceApi {
    QuadroDemandasDTO criarQuadroDemandas(QuadroDemandasDTO quadroDemandasDTO);
    QuadroDemandasDTO buscarQuadroDemandasPorId(Long id);
    List<QuadroDemandasDTO> listarQuadrosDemandas();
    void deletarQuadroDemandas(Long id);
}