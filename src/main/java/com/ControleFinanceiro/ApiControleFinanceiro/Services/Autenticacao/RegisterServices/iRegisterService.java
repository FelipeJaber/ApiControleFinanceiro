package com.ControleFinanceiro.ApiControleFinanceiro.Services.Autenticacao.RegisterServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.RegisterRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Autenticacao.RegisterResponseRecord;
import org.springframework.stereotype.Service;

@Service
public interface iRegisterService {
    public RegisterResponseRecord register(RegisterRecord registerRecord) throws Exception;
}
