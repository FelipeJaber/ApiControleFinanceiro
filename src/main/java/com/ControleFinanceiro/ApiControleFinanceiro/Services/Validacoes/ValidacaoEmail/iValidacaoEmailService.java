package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoEmail;

import org.springframework.stereotype.Service;

@Service
public interface iValidacaoEmailService {
    public boolean isEmailValid(String email);
}
