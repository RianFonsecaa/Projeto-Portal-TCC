package com.ifba.Gerenciador_TCC.reuniao.domain.repository;

import com.ifba.Gerenciador_TCC.reuniao.domain.entity.Reuniao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReuniaoRepository extends JpaRepository<Reuniao, Long> {


    List<Reuniao> findByIdUsuario(Long idusuario);

    List<Reuniao> findByNomeReuniao(String nomeReuniao);

    List<Reuniao> findByDataReuniao(LocalDate dataReuniao);

}
