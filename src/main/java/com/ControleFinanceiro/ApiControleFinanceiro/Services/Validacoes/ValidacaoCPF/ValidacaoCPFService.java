package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoCPF;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoCPFService implements iValidacaoCPFService {
    @Override
    public boolean isCPFValid(String cpf) {
        return true;
    }
}
