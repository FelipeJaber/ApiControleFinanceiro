package com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record CreateMetaRecord(
        @NotEmpty(message = "tipo não pode ser vazio ou nulo") TipoLancamentoEnum tipo,
        @NotEmpty(message = "valor não pode ser vazio ou nulo") String valor,
        @NotEmpty(message = "idGrupo não pode ser vazio ou nulo") UUID idGrupo) {
}
