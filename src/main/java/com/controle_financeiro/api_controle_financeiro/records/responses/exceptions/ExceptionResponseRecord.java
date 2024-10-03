package com.controle_financeiro.api_controle_financeiro.records.responses.exceptions;

import jakarta.validation.constraints.NotBlank;

public record ExceptionResponseRecord(
        @NotBlank String error
) {
}
