package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.GetAllGruposServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security.UserCredentials;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.GetAllGruposResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iGrupoRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllGruposService implements iGetAllGruposService{
    iGrupoRepository grupoRepository;
    iPessoaRepository pessoaRepository;

    @Autowired
    public GetAllGruposService(iGrupoRepository grupoRepository, iPessoaRepository pessoaRepository) {
        this.grupoRepository = grupoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public GetAllGruposResponseRecord getAllGrupos() throws Exception {
        List<GrupoModel> gruposList = getListaGruposUsuario();
        return getGetAllGruposResponse(gruposList);
    }

    private List<GrupoModel> getListaGruposUsuario() throws Exception {
        return UserCredentials.getInstance().getUserModel().getGrupos();
    }

    private GetAllGruposResponseRecord getGetAllGruposResponse(List<GrupoModel> grupos) throws Exception{
        return new GetAllGruposResponseRecord("Success",grupos);
    }
}
