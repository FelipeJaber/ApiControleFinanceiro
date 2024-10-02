package com.ControleFinanceiro.ApiControleFinanceiro.Enums;

import lombok.Getter;

@Getter
public enum ExceptionsEnum {
    ACCESS_DENIED_INVALID_CREDENTIALS(403, "Access denied, invalid credentials."),
    UNHANDLED_EXCEPTION(500, "Unhandled exception."),
    DUPLICATE_DATA(409, "Duplicate data found."),
    DUPLICATE_CPF(409, "Duplicate CPF found."),
    DUPLICATE_TELEFONE(409, "Duplicate telephone number found."),
    DUPLICATE_EMAIL(409, "Duplicate email address found."),
    INVALID_CPF(400, "Invalid CPF."),
    INVALID_TELEFONE(400, "Invalid telephone number."),
    INVALID_EMAIL(400, "Invalid email address.");

    private final int error_code;
    private final String error_text;

    ExceptionsEnum(int error_code, String error_text) {
        this.error_code = error_code;
        this.error_text = error_text;
    }
}
