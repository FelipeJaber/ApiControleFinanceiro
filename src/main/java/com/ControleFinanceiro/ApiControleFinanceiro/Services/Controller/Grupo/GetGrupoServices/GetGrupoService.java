package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.GetGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.GetGrupoResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetGrupoService implements iGetGrupoService{
    iGrupoRepository grupoRepository;

    @Autowired
    public GetGrupoService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public GetGrupoResponseRecord getGrupo(UUID idGrupo) throws Exception {
        GrupoModel grupoToBeReturned = findGrupo(idGrupo);
        return getGetGrupoResponse(grupoToBeReturned);
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

    private GetGrupoResponseRecord getGetGrupoResponse(GrupoModel grupo) throws Exception{
        return new GetGrupoResponseRecord("Success", grupo);
    }
}
