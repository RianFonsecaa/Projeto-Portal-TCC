package com.ifba.Gerenciador_TCC.tcc.interfaces;

import com.ifba.Gerenciador_TCC.tcc.domain.dto.TccDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface TccControllerApi {

    ResponseEntity<TccDTO> criarTcc(TccDTO tccDTO);

    ResponseEntity<TccDTO> buscarTccPorId(Long id);

    ResponseEntity<List<TccDTO>> listarTccs();

    ResponseEntity<TccDTO> atualizarTcc(Long id, TccDTO tccDTO);

    ResponseEntity<Void> deletarTcc(Long id);
}
