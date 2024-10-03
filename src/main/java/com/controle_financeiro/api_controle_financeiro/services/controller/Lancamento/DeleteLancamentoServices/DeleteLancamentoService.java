package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.DeleteLancamentoServices;


import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.LancamentoModel;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.DeleteLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iLancamentoRepository;

import java.util.Optional;
import java.util.UUID;

public class DeleteLancamentoService implements iDeleteLancamentoService {

    iLancamentoRepository lancamentoRepository;

    public DeleteLancamentoService(iLancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public DeleteLancamentoResponseRecord deleteLancamento(UUID idLancamento) throws Exception {
        LancamentoModel lancamentoToBeDeleted = findLancamento(idLancamento);
        deleteLancamento(lancamentoToBeDeleted);
        return new DeleteLancamentoResponseRecord("Success");
    }

    private LancamentoModel findLancamento(UUID idLancamento) throws Exception{
        Optional<LancamentoModel> lancamento = lancamentoRepository.findById(idLancamento);
        if(lancamento.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_LANCAMENTO.name());
        if(lancamento.get().getGrupo().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return lancamento.get();
    }

    private void deleteLancamento(LancamentoModel lancamentoModel) throws  Exception{
        lancamentoRepository.delete(lancamentoModel);
    }
}
