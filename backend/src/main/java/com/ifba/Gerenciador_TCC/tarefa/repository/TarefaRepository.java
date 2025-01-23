package com.ifba.Gerenciador_TCC.tarefa.repository;

import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


    List<Tarefa> findByIdUsuario(Long idUsuario);

    List<Tarefa> findByNomeTarefa(String nomeTarefa);

    List<Tarefa> findByDataEnvio(LocalDate dataEnvio);

    List<Tarefa> findByDataFim(LocalDate dataFim);
}
