package com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.LancamentoModel;

import java.util.List;

public record GetAllLancamentosResponseRecord(List<LancamentoModel> lancamentos) {
}
