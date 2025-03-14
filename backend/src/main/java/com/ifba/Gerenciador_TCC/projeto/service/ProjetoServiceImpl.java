package com.ifba.Gerenciador_TCC.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.projeto.builder.InfoProjetoDTOBuilder;
import com.ifba.Gerenciador_TCC.projeto.builder.ProjetoDTOBuilder;
import com.ifba.Gerenciador_TCC.projeto.domain.dto.InfoProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.dto.ProjetoDTO;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.projeto.repository.ProjetoRepository;
import com.ifba.Gerenciador_TCC.tarefa.service.TarefaService;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private UsuarioServiceApi usuarioService;

    @Autowired
    private TarefaService tarefaService;


    @Override
    public InfoProjetoDTO buscarInfoProjetoPorOrientando(Long idOrientando){
        Projeto projeto = projetoRepository.findByOrientandoId(usuarioService.findById(idOrientando));
        return InfoProjetoDTOBuilder.buildInfoProjetoDTO(projeto, tarefaService);
    }


    @Override
    public List<InfoProjetoDTO> buscarInfoProjetoPorOrientador(Long idOrientador){
        System.out.println(usuarioService.findById(idOrientador));
        List<Projeto> projetos = projetoRepository.findByOrientadorId(usuarioService.findById(idOrientador));
        return projetos.stream()
            .map(projeto -> InfoProjetoDTOBuilder.buildInfoProjetoDTO(projeto, tarefaService))
            .collect(Collectors.toList());
    }
    

    @Override
    public List<ProjetoDTO> listarProjetosPorOrientador(Long idOrientador) {
        List<Projeto> projetos = projetoRepository.findByOrientadorId(usuarioService.findById(idOrientador));
        return projetos.stream()
                .map(ProjetoDTOBuilder::buildProjetoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Projeto findById(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (!projeto.isPresent())
            throw new NotFoundException("Projeto Não Encontrado");
        return projeto.get();
    }

}
