package com.ifba.Gerenciador_TCC.projeto.service;

import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.domain.repository.ProjetoRepository;
import com.ifba.Gerenciador_TCC.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    @Override
    public Buscar<Projeto> obterProjetoPorId(Long id) {
        return projetoRepository.findById(id);
    }

    @Override
    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto atualizarProjeto(Long id, Projeto projeto) {
        if (projetoRepository.existsById(id)) {
            projeto.setId(id);
            return projetoRepository.save(projeto);
        }
        return null;
    }

    @Override
    public void deletarProjeto(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
        }
    }
}
