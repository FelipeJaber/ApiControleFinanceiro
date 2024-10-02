package com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo;

import jakarta.validation.constraints.NotEmpty;

public record CreateGrupoRecord(
        @NotEmpty(message = "Nome não pode ser vazio ou nulo")String nome,
        @NotEmpty(message = "Descricao não pode ser vazio ou nulo")String descricao) {
}
