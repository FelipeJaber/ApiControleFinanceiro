package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoEmail;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoEmailService implements iValidacaoEmailService {
    @Override
    public boolean isEmailValid(String email) {
        return true;
    }
}
