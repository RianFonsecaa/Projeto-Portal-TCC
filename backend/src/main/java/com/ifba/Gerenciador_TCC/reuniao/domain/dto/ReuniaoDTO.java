package com.ifba.Gerenciador_TCC.reuniao.domain.dto;

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
public class ReuniaoDTO {

    private Long id;

    @NotNull(message = "O ID dos usuários não pode ser vazio")
    private Long idUsuario;

    @NotEmpty(message = "O nome da reuniao não pode estar vazio")
    private String nomeReuniao;

    private String descricao;

    @NotNull(message = "A data da reunião não pode estar vazia")
    private LocalDate dataReuniao;

}
