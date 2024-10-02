package com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Exceptions;

import jakarta.validation.constraints.NotBlank;

public record ExceptionResponseRecord(
        @NotBlank String error
) {
}
