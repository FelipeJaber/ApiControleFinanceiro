package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.UpdateGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.UpdateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.UpdateGrupoResponseRecord;

public interface iUpdateGrupoService {
    public UpdateGrupoResponseRecord updateGrupo(UpdateGrupoRecord updateGrupoRecord) throws Exception;
}
