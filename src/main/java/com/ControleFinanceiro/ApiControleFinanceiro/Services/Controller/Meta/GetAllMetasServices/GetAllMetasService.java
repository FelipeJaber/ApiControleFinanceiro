package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.GetAllMetasServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.GetAllMetasResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetAllMetasService implements iGetAllMetasService{

    iGrupoRepository grupoRepository;

    @Autowired
    public GetAllMetasService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public GetAllMetasResponseRecord getAllMetas(UUID groupId) throws Exception {
        GrupoModel grupo = findGrupo(groupId);
        return new GetAllMetasResponseRecord(grupo.getMetas());
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

}
