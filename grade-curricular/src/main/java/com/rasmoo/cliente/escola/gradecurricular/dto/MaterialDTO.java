package com.rasmoo.cliente.escola.gradecurricular.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class MaterialDTO {


    private Long id;
    @NotBlank(message = "Informe o nome da materia")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome ;

    private String codigo;

    private String frequencia;


}
