package com.ifba.Gerenciador_TCC.projeto.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "ID do aluno não pode ser vazio")
    @Column(name = "id_aluno", nullable = false)
    private Long idAluno;

    @NotNull(message = "ID do professor não pode ser vazio")
    @Column(name = "id_professor", nullable = false)
    private Long idProfessor;

    @NotNull(message = "ID do TCC não pode ser vazio")
    @Column(name = "id_tcc", nullable = false)
    private Long idTcc;

    @NotEmpty(message = "O título do projeto não pode estar vazio")
    @Column(name = "titulo_projeto", nullable = false, length = 200)
    private String tituloProjeto;

    @Column(name = "descricao_projeto", columnDefinition = "TEXT")
    private String descricaoProjeto;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;
}
