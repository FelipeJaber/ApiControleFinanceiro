package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.GetAllLancamentosServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.GetAllLancamentosResponseRecord;

import java.util.UUID;

public interface iGetAllLancamentosService {
    public GetAllLancamentosResponseRecord getAllLancamentos(UUID groupId) throws Exception;
}
