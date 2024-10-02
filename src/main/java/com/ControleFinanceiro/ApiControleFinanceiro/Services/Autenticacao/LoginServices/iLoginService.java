package com.ControleFinanceiro.ApiControleFinanceiro.Services.Autenticacao.LoginServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.LoginRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Autenticacao.LoginResponseRecord;
import org.springframework.stereotype.Service;

@Service
public interface iLoginService {
    public LoginResponseRecord login(LoginRecord loginRecord) throws Exception;
}
