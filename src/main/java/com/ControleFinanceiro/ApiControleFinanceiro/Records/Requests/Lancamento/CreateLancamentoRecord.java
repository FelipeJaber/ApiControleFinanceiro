package com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.CategoriaLancamentoEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateLancamentoRecord(@NotEmpty(message = "Nome não pode ser vazio ou nulo") String nome,
                                     @NotEmpty(message = "Descricao não pode ser vazio ou nulo") String descricao,
                                     @NotEmpty(message = "Data não pode ser vazio ou nulo") OffsetDateTime data,
                                     @NotEmpty(message = "Tipo não pode ser vazio ou nulo") TipoLancamentoEnum tipo,
                                     @NotEmpty(message = "Valor não pode ser vazio ou nulo") BigDecimal valor,
                                     @NotEmpty(message = "Categoria não pode ser vazio ou nulo") CategoriaLancamentoEnum categoria,
                                     @NotEmpty(message = "idGrupo não pode ser vazio ou nulo") UUID idGrupo) {
}
