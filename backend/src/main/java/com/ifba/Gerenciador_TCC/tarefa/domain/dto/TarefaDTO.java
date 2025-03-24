package com.ifba.Gerenciador_TCC.tarefa.domain.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Classificacao;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Prioridade;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaDTO {

    private Long id;

    @NotNull(message = "O ID do orientando não pode estar vazio")
    private Long projetoId;

    @NotEmpty(message = "O nome da tarefa não pode estar vazio")
    private String nomeTarefa;

    @NotEmpty(message = "A descrição da tarefa não pode estar vazia")
    private String descricao;

    @NotNull(message = "O status da tarefa é obrigatório")
    private StatusTarefa status;

    @NotNull(message = "A prioridade é obrigatória")
    private Prioridade prioridade;

    @NotNull(message = "A classificação é obrigatória")
    private Classificacao classificacao;

    @NotNull(message = "O prazo da tarefa é obrigatório")
    private LocalDate prazo;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime  ultimaAtualizacao;
    
}
