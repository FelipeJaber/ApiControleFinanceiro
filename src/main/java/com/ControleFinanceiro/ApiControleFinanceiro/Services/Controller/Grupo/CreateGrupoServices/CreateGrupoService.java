package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.CreateGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.CreateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.CreateGrupoResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateGrupoService implements iCreateGrupoService{

    iGrupoRepository grupoRepository;

    @Autowired
    public CreateGrupoService(iGrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @Override
    public CreateGrupoResponseRecord createGrupo(CreateGrupoRecord createGrupoRecord) throws Exception {
        GrupoModel newGrupo = createNewGrupoModel(createGrupoRecord);
        newGrupo = saveNewGrupo(newGrupo);
        return createCreateGrupoResponse(newGrupo);
    }

    private GrupoModel createNewGrupoModel(CreateGrupoRecord createGrupoRecord) throws Exception{
        GrupoModel grupoModel = new GrupoModel();
        grupoModel.setDescricaoGrupo(createGrupoRecord.descricao());
        grupoModel.setNomeGrupo(createGrupoRecord.nome());
        grupoModel.setDonoGrupo(UserCredentials.getInstance().getUserModel());
        return grupoModel;
    }

    private GrupoModel saveNewGrupo(GrupoModel grupoToBeSaved) throws Exception{
        return grupoRepository.save(grupoToBeSaved);
    }

    private CreateGrupoResponseRecord createCreateGrupoResponse(GrupoModel grupoModel) throws Exception{
        return new CreateGrupoResponseRecord("Success",grupoModel);
    }
}
