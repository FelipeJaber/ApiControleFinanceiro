package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.UpdateGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.UpdateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.UpdateGrupoResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateGrupoService implements iUpdateGrupoService{
    iGrupoRepository grupoRepository;

    @Autowired
    public UpdateGrupoService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public UpdateGrupoResponseRecord updateGrupo(UpdateGrupoRecord updateGrupoRecord) throws Exception {
        GrupoModel grupoToBeAltered = findGrupo(updateGrupoRecord.id());
        grupoToBeAltered = alterGrupo(grupoToBeAltered,updateGrupoRecord);
        return createUpdateGrupoResponse(grupoToBeAltered);
    }

    private GrupoModel findGrupo(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupo = grupoRepository.findById(idGrupo);
        if(grupo.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        if(grupo.get().getDonoGrupo().getIdPessoa() != UserCredentials.getInstance().getUserModel().getIdPessoa()) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        return grupo.get();
    }

    private GrupoModel alterGrupo(GrupoModel grupoToBeAltered, UpdateGrupoRecord updateGrupoRecord)throws Exception{
        grupoToBeAltered.setDescricaoGrupo(updateGrupoRecord.descricao());
        grupoToBeAltered.setNomeGrupo(updateGrupoRecord.nome());
        return grupoToBeAltered;
    }

    private UpdateGrupoResponseRecord createUpdateGrupoResponse(GrupoModel alteredGrupo)throws Exception{
        return new UpdateGrupoResponseRecord("Success", alteredGrupo);
    }
}
