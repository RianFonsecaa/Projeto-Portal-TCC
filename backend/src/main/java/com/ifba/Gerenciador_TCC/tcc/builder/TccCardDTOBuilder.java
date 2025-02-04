package com.ifba.Gerenciador_TCC.tcc.builder;


import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccCardDTO;
import com.ifba.Gerenciador_TCC.tcc.domain.entity.Tcc;

public class TccCardDTOBuilder {

    public static TccCardDTO buildTccCardDTO(Tcc tcc) {
    
        return TccCardDTO.builder()
                .id(tcc.getId())
                .titulo(tcc.getTitulo())
                .demandasAtribuidas(tcc.getQuadroDemandas() != null ? tcc.getQuadroDemandas().getDemandasAtribuidas() : 0)
                .demandasEmAndamento(tcc.getQuadroDemandas() != null ? tcc.getQuadroDemandas().getDemandasEmAndamento() : 0)
                .demandasResolvidas(tcc.getQuadroDemandas() != null ? tcc.getQuadroDemandas().getDemandasResolvidas() : 0)
                .build();
    }
}
