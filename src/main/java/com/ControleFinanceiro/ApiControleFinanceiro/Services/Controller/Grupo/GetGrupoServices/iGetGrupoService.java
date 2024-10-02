package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.GetGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.GetGrupoResponseRecord;

import java.util.UUID;

public interface iGetGrupoService {
    public GetGrupoResponseRecord getGrupo(UUID idGrupo) throws Exception;
}
