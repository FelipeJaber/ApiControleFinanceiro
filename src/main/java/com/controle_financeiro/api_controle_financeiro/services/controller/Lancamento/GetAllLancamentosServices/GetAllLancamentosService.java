package com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.GetAllLancamentosServices;

import com.controle_financeiro.api_controle_financeiro.configurations.security.UserCredentials;
import com.controle_financeiro.api_controle_financeiro.enums.ExceptionsEnum;
import com.controle_financeiro.api_controle_financeiro.models.GrupoModel;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.GetAllLancamentosResponseRecord;
import com.controle_financeiro.api_controle_financeiro.repositories.iGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetAllLancamentosService implements iGetAllLancamentosService{

    iGrupoRepository grupoRepository;

    @Autowired
    public GetAllLancamentosService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public GetAllLancamentosResponseRecord getAllLancamentos(UUID groupId) throws Exception {
        GrupoModel grupo = findGrupo(groupId);
        return new GetAllLancamentosResponseRecord(grupo.getLancamentos());
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

}
