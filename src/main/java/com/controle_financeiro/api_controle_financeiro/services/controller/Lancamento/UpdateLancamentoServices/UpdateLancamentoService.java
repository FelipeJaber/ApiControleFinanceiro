package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.UpdateLancamentoServices;

import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.LancamentoModel;
import com.controle_financeiro.api_controle_financeiro.records.requests.lancamento.UpdateLancamentoRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.UpdateLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iLancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateLancamentoService implements iUpdateLancamentoService{

    iLancamentoRepository lancamentoRepository;

    @Autowired
    public UpdateLancamentoService(iLancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public UpdateLancamentoResponseRecord updateLancamento(UpdateLancamentoRecord updateLancamentoRecord) throws Exception {
        LancamentoModel lancamentoToBeAltered = findLancamento(updateLancamentoRecord.idLancamento());
        LancamentoModel alteredLancamento = updateLancamento(lancamentoToBeAltered, updateLancamentoRecord);
        alteredLancamento = saveNewLancamento(alteredLancamento);
        return new UpdateLancamentoResponseRecord(alteredLancamento);
    }

    private LancamentoModel findLancamento(UUID idLancamento) throws Exception{
        Optional<LancamentoModel> lancamento = lancamentoRepository.findById(idLancamento);
        if(lancamento.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_LANCAMENTO.name());
        if(lancamento.get().getGrupo().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return lancamento.get();
    }

    private LancamentoModel saveNewLancamento(LancamentoModel lancamentoModel) throws  Exception{
        return lancamentoRepository.save(lancamentoModel);
    }

    private LancamentoModel updateLancamento(LancamentoModel lancamentoToBeAltered, UpdateLancamentoRecord updateLancamentoRecord) throws Exception{
        lancamentoToBeAltered.setCategoriaLancamento(updateLancamentoRecord.categoria());
        lancamentoToBeAltered.setTipoLancamento(updateLancamentoRecord.tipo());
        lancamentoToBeAltered.setNome(updateLancamentoRecord.nome());
        lancamentoToBeAltered.setValor(updateLancamentoRecord.valor());
        lancamentoToBeAltered.setDescricao(updateLancamentoRecord.descricao());
        lancamentoToBeAltered.setData(updateLancamentoRecord.data());
        return lancamentoToBeAltered;
    }
}
