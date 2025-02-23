
package com.ifba.Gerenciador_TCC.reuniao.domain.entity;

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
@Table(name = "reuniao")
public class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O ID do usuário não pode ser vazio")
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @NotEmpty(message = "O nome da reuniao não pode estar vazio")
    @Column(name = "nome_reuniao", nullable = false, length = 200)
    private String nomeReuniao;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "A data da reunião não pode estarr vazia")
    @Column(name = "data_reuniao", nullable = false)
    private LocalDate dataReuniao;
}
