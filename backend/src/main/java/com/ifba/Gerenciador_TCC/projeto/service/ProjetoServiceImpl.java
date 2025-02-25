package com.ifba.Gerenciador_TCC.projeto.service;

import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.projeto.domain.entity.Projeto;
import com.ifba.Gerenciador_TCC.projeto.interfaces.ProjetoService;
import com.ifba.Gerenciador_TCC.projeto.repository.ProjetoRepository;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;
import com.ifba.Gerenciador_TCC.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private UsuarioServiceApi usuarioService;
    @Override
    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    @Override
    public List<Projeto> listarProjetosPorOrientador(Long idOrientador) {
        return projetoRepository.findByOrientadorId(usuarioService.findById(idOrientador));
    }

    @Override
    public Projeto obterProjetoPorId(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (!projeto.isPresent())
            throw new NotFoundException("Projeto Não Encontrado");
        return projeto.get();
    }

    @Override
    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto atualizarProjeto(Projeto projeto) {
        if (projetoRepository.existsById(projeto.getId())) {
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

    @Override
    public Projeto findById(long projetoId) {
    return projetoRepository.findById(projetoId)
        .orElseThrow(() -> new NotFoundException("Projeto não encontrado com ID: " + projetoId));
    }
}
