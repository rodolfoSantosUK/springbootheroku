package com.rasmoo.cliente.escola.gradecurricular.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ErroMapResponse {
    private int httpStatus;

    private Map<String, String> erros;

    private Long timeStamp;

}
