package com.ifba.Gerenciador_TCC.usuario.service;

import com.ifba.Gerenciador_TCC.exceptions.NotFoundException;
import com.ifba.Gerenciador_TCC.security.CustomUserDetailsService;
import com.ifba.Gerenciador_TCC.security.JwtTokenUtil;
import com.ifba.Gerenciador_TCC.usuario.controller.JwtResponse;
import com.ifba.Gerenciador_TCC.usuario.domain.dto.UsuarioDTO;
import com.ifba.Gerenciador_TCC.login.domain.LoginRequest;
import com.ifba.Gerenciador_TCC.tipoenum.TipoUsuario;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import com.ifba.Gerenciador_TCC.usuario.interfaces.UsuarioServiceApi;
import com.ifba.Gerenciador_TCC.usuario.mapper.UsuarioMapper;
import com.ifba.Gerenciador_TCC.usuario.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UsuarioService implements UsuarioServiceApi {

    @Autowired
    private final UsuarioMapper usuarioMapper;
    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;

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

    public Optional<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario) {
        return usuarioRepository.findByTipoUsuario(tipoUsuario);
    }

    public ResponseEntity<?> login(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

        Usuario usuario = findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return ResponseEntity.ok(new JwtResponse(token, usuario));
    }
}
