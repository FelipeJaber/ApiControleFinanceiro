package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.DeleteGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.DeleteGrupoResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteGrupoService implements iDeleteGrupoService{
    iGrupoRepository grupoRepository;

    @Autowired
    public DeleteGrupoService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public DeleteGrupoResponseRecord DeleteGrupo(UUID idGrupo) throws Exception {
        GrupoModel grupoToBeDeleted = getGrupoToBeDeleted(idGrupo);
        if(!usarCanDeleteGroup(grupoToBeDeleted)) throw new Exception(ExceptionsEnum.ACCESS_DENIED_INSUFFICIENT_PERMISSION.name());
        deleteGroup(grupoToBeDeleted);
        return createDeleteGroupResponse();
    }

    private GrupoModel getGrupoToBeDeleted(UUID idGrupo) throws Exception{
        Optional<GrupoModel> grupoToBeDeleted = grupoRepository.findById(idGrupo);
        if(grupoToBeDeleted.isEmpty()) throw new Exception(ExceptionsEnum.INVALID_ID_GRUPO.name());
        return grupoToBeDeleted.get();
    }

    private boolean usarCanDeleteGroup(GrupoModel grupoToBeDeleted) throws Exception{
        return UserCredentials.getInstance().getUserModel().getIdPessoa().equals(grupoToBeDeleted.getDonoGrupo().getIdPessoa());
    }

    private void deleteGroup(GrupoModel groupToBeDeleted) throws Exception{
        grupoRepository.delete(groupToBeDeleted);
    }

    private DeleteGrupoResponseRecord createDeleteGroupResponse()throws Exception{
        return new DeleteGrupoResponseRecord("Success");
    }
}
