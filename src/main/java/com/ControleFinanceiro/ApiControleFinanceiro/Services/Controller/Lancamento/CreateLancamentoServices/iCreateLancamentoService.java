package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.CreateLancamentoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento.CreateLancamentoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.CreateLancamentoResponseRecord;

public interface iCreateLancamentoService {
    public CreateLancamentoResponseRecord createLancamento(CreateLancamentoRecord createLancamentoRecord) throws Exception;
}
