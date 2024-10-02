package com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoTelefone;

import org.springframework.stereotype.Service;

@Service
public interface iValidacaoTelefoneService {
    public boolean isTelefoneValid(String telefone);
}
