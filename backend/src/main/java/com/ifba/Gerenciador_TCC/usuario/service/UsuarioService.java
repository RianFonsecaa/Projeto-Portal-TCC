package com.ifba.Gerenciador_TCC.usuario.service;

import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.login.domain.LoginRequest;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;
import com.ifba.Gerenciador_TCC.usuario.mapper.UsuarioMapper;
import com.ifba.Gerenciador_TCC.usuario.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UsuarioService implements UsuarioServiceApi {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(UsuarioDTO usuarioDTO) {
        return this.usuarioRepository.save(usuarioMapper.dtoToUsuario(usuarioDTO));
    }

    @Override
    public Usuario update(UsuarioDTO usuarioDTO) {
        if (!this.usuarioRepository.existsById(usuarioDTO.getId())) {
            throw new NotFoundException("Usuario não encontrado");
        }
        return this.create(usuarioDTO);
    }

    @Override
    public void delete(long id) {
        if (!this.usuarioRepository.existsById(id))
            throw new NotFoundException("Usuario não encontrado");

        this.usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (!usuario.isPresent())
            return null;
        return usuario.get();
    }


    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
