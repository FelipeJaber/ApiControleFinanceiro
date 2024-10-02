package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.CreateGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.CreateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.CreateGrupoResponseRecord;

public interface iCreateGrupoService {
    public CreateGrupoResponseRecord createGrupo(CreateGrupoRecord createGrupoRecord) throws Exception;
}
