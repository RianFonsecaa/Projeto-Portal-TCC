package com.ifba.Gerenciador_TCC.tarefa.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

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

    private String codigo;

    @NotNull(message = "O ID do projeto não pode estar vazio")
    private Long projetoId;

    @NotEmpty(message = "O título da tarefa não pode estar vazio")
    private String titulo;

    @NotEmpty(message = "A descrição da tarefa não pode estar vazia")
    private String descricao;

    @NotNull(message = "O status da tarefa é obrigatório")
    private String status;

    @NotNull(message = "A prioridade é obrigatória")
    private String prioridade;

    @NotEmpty(message = "A etapa da tarefa não pode estar vazia")
    private String etapa;

    @NotNull(message = "A classificação é obrigatória")
    private String classificacao;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ultimaAtualizacaoEm;

    @NotEmpty
    private String ultimaAtualizacaoPor;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime criacaoEm;

    @NotEmpty
    private String criacaoPor;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    public void gerarCodigo() {
        if (this.codigo == null) {
            this.codigo = gerarCodigoAleatorio();
        }
    }

    private String gerarCodigoAleatorio() {
        char letra = (char) ('A' + new Random().nextInt(26));
        int numero = 1000 + new Random().nextInt(9000); // 1000 a 9999
        return String.format("%c%d", letra, numero);
    }
}