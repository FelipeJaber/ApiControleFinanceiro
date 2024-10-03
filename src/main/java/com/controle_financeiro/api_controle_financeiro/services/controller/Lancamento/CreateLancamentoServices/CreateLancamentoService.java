package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.CreateLancamentoServices;

import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.GrupoModel;
import com.controle_financeiro.api_controle_financeiro.models.LancamentoModel;
import com.controle_financeiro.api_controle_financeiro.records.requests.lancamento.CreateLancamentoRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.CreateLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iGrupoRepository;
import com.controle_financeiro.api_controle_financeiro.repositories.iLancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CreateLancamentoService implements iCreateLancamentoService{

    iGrupoRepository grupoRepository;
    iLancamentoRepository lancamentoRepository;

    @Autowired
    public CreateLancamentoService(iGrupoRepository grupoRepository, iLancamentoRepository lancamentoRepository) {
        this.grupoRepository = grupoRepository;
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public CreateLancamentoResponseRecord createLancamento(CreateLancamentoRecord createLancamentoRecord) throws Exception {
        GrupoModel grupo = findGrupo(createLancamentoRecord.idGrupo());
        LancamentoModel newLancamento = createNewLancamento(createLancamentoRecord,grupo);
        return new CreateLancamentoResponseRecord("Success",newLancamento);
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

    private LancamentoModel createNewLancamento(CreateLancamentoRecord createLancamentoRecord, GrupoModel grupo)throws Exception{
        LancamentoModel newLancamento = new LancamentoModel();

        newLancamento.setValor(createLancamentoRecord.valor());
        newLancamento.setTipoLancamento(createLancamentoRecord.tipo());
        newLancamento.setData(createLancamentoRecord.data());
        newLancamento.setGrupo(grupo);
        newLancamento.setDescricao(createLancamentoRecord.descricao());
        newLancamento.setCategoriaLancamento(createLancamentoRecord.categoria());
        newLancamento.setNome(createLancamentoRecord.nome());

        return lancamentoRepository.save(newLancamento);
    }
}
