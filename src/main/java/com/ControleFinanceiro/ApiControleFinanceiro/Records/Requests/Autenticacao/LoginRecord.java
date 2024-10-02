package com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao;

import jakarta.validation.constraints.NotEmpty;

public record LoginRecord(@NotEmpty(message = "CPF não pode ser vazio ou nulo") String cpf,
                          @NotEmpty(message = "Email não pode ser vazio ou nulo")String email
) {
}
