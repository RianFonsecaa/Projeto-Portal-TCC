package com.ifba.Gerenciador_TCC.tarefa.repository;

import java.util.List;

import com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(StatusTarefa status);

    List<Tarefa> findByProjetoId(Long projetoId);

    @Query("SELECT new com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO(t.descricao, t.dataFim) FROM Tarefa t " +
            "LEFT JOIN t.projeto p " +
            "WHERE p.orientadorId.id = :orientadorId")
    List<TarefaAgendaDTO> findAgendaByOrientador(@Param("orientadorId") Long orientadorId);

    @Query("SELECT new com.ifba.Gerenciador_TCC.agenda.domain.dto.TarefaAgendaDTO(t.descricao, t.dataFim) FROM Tarefa t " +
            "LEFT JOIN t.projeto p " +
            "WHERE p.orientandoId.id = :orientandoId")
    List<TarefaAgendaDTO> findAgendaByOrientando(@Param("orientandoId") Long orientandoId);
}
