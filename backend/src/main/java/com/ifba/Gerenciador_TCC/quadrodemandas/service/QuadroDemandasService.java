package com.ifba.Gerenciador_TCC.quadrodemandas.service;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.quadrodemandas.builder.QuadroDemandasDTOBuilder;
import com.ifba.Gerenciador_TCC.quadrodemandas.domain.dto.QuadroDemandasDTO;
import com.ifba.Gerenciador_TCC.quadrodemandas.interfaces.QuadroDemandasServiceApi;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuadroDemandasService implements QuadroDemandasServiceApi {
    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private ProjetoService projetoService;
    public List<QuadroDemandasDTO> buscarQuadroPorOrientador(Long idOrientador){
        List<Projeto> projetos = projetoService.listarProjetosPorOrientador(idOrientador);
        return projetos.stream()
                .map(projeto -> QuadroDemandasDTOBuilder.buildQuadroDemandas(projeto, tarefaService))
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> buscarQuadroPorProjeto(Long idOrientador){
        Optional<Projeto> projeto = Optional.ofNullable(projetoService.obterProjetoPorId(idOrientador));

        if (!projeto.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(QuadroDemandasDTOBuilder.buildQuadroDemandas(projeto.get(), tarefaService));
    }

}