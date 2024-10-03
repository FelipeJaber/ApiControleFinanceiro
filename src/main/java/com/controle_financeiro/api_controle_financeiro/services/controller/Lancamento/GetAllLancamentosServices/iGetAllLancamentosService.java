package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.GetAllLancamentosServices;

import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.GetAllLancamentosResponseRecord;

import java.util.UUID;

public interface iGetAllLancamentosService {
    public GetAllLancamentosResponseRecord getAllLancamentos(UUID groupId) throws Exception;
}
