package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoCPF;

import org.springframework.stereotype.Service;

@Service
public interface iValidacaoCPFService {
    public boolean isCPFValid(String cpf);
}
