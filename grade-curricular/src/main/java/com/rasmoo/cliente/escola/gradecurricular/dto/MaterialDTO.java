package com.rasmoo.cliente.escola.gradecurricular.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class MaterialDTO {

    private Long id;

    @NotBlank(message = "Informe o código da materia")
    private String nome;
    private String codigo;
    private int sequencia;
    private String frequencia;


}
