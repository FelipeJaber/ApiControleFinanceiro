package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoTelefone;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoTelefoneService implements iValidacaoTelefoneService{
    @Override
    public boolean isTelefoneValid(String telefone) {
        return true;
    }
}
