package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.DeleteLancamentoServices;

import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.DeleteLancamentoResponseRecord;

import java.util.UUID;

public interface iDeleteLancamentoService {
    public DeleteLancamentoResponseRecord deleteLancamento(UUID idLancamento) throws Exception;
}
