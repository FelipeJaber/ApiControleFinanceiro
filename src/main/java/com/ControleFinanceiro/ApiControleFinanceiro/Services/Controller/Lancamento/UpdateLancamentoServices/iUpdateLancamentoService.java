package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.UpdateLancamentoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento.UpdateLancamentoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.UpdateMetaResponseRecord;

public interface iUpdateLancamentoService {
    public UpdateMetaResponseRecord updateLancamento(UpdateLancamentoRecord updateLancamentoRecord) throws Exception;
}
