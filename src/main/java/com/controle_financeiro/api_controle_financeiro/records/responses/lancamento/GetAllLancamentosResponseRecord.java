package com.controle_financeiro.api_controle_financeiro.records.responses.lancamento;

import com.controle_financeiro.api_controle_financeiro.models.LancamentoModel;

import java.util.List;

public record GetAllLancamentosResponseRecord(List<LancamentoModel> lancamentos) {
}
