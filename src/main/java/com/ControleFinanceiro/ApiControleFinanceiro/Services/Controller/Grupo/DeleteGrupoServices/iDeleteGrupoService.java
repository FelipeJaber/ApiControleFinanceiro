package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.DeleteGrupoServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo.DeleteGrupoResponseRecord;

import java.util.UUID;

public interface iDeleteGrupoService {
    public DeleteGrupoResponseRecord DeleteGrupo(UUID idGrupo) throws Exception;
}
