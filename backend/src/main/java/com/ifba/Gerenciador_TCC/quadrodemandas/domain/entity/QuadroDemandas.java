package com.ifba.Gerenciador_TCC.quadrodemandas.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "quadro_demandas")
public class QuadroDemandas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "demandas_atribuidas")
    private int demandasAtribuidas;

    @Column(name = "demandas_em_andamento")
    private int demandasEmAndamento;

    @Column(name = "demandas_resolvidas")
    private int demandasResolvidas;
}
