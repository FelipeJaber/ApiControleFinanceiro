package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.GetAllLancamentosServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.GetAllLancamentosResponseRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetAllLancamentosService implements iGetAllLancamentosService{
    @Override
    public GetAllLancamentosResponseRecord getAllLancamentos(UUID groupId) throws Exception {
        return null;
    }
}
