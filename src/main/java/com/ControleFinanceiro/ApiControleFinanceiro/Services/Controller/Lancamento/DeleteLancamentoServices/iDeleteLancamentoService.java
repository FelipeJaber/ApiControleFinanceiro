package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.DeleteLancamentoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.DeleteLancamentoResponseRecord;

import java.util.UUID;

public interface iDeleteLancamentoService {
    public DeleteLancamentoResponseRecord deleteLancamento(UUID idLancamento) throws Exception;
}
