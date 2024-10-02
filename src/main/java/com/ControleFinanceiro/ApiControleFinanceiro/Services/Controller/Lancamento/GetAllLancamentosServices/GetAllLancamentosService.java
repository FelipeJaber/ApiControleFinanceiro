package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.GetAllLancamentosServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Lancamento.GetAllLancamentosResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iLancamentoRepository;
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
