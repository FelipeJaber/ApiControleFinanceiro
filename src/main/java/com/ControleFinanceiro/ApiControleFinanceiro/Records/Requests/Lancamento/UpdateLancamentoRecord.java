package com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento;

import jakarta.validation.constraints.NotEmpty;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UpdateLancamentoRecord(@NotEmpty(message = "Nome não pode ser vazio ou nulo") String nome,
                                     @NotEmpty(message = "Descricao não pode ser vazio ou nulo") String descricao,
                                     @NotEmpty(message = "Data não pode ser vazio ou nulo") OffsetDateTime data,
                                     @NotEmpty(message = "Tipo não pode ser vazio ou nulo") String tipo,
                                     @NotEmpty(message = "Valor não pode ser vazio ou nulo") String valor,
                                     @NotEmpty(message = "Categoria não pode ser vazio ou nulo") String categoria,
                                     @NotEmpty(message = "idGrupo não pode ser vazio ou nulo") UUID idGrupo) {
}
