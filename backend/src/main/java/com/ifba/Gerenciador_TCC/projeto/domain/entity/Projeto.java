package com.ifba.Gerenciador_TCC.projeto.domain.entity;

import com.ifba.Gerenciador_TCC.tipoenum.TipoProjeto;
import com.ifba.Gerenciador_TCC.tipoenum.TipoCurso;
import com.ifba.Gerenciador_TCC.usuario.domain.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orientando_id", referencedColumnName = "id", nullable = false, unique = false)
    private Usuario orientandoId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orientador_id", referencedColumnName = "id", nullable = false, unique = false)
    private Usuario orientadorId;

    @NotEmpty(message = "O título do projeto não pode estar vazio")
    @Column(name = "titulo_projeto", nullable = false, length = 200)
    private String tituloProjeto;

    @Column(name = "descricao_projeto", columnDefinition = "TEXT")
    private String descricaoProjeto;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;
    
    @Column(name = "data_Ultima_Atualizacao", nullable = false)
    private LocalDate dataUltimaAtualizacao;

    @Column(name = "horas_Orientacao", nullable = false)
    private int horasOrientacao;
    
    @Column(name = "progresso", nullable = false)
    private int progresso;
    
    @Column(name = "url_imagem", nullable = false)
    private String urlImagemCard; 

    @Enumerated(EnumType.STRING)
    @Column
    private TipoProjeto tipoProjeto;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoCurso tipoCurso;

  
}
