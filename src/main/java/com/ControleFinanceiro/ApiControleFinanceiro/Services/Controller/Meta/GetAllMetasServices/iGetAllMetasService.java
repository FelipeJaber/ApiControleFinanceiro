package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.GetAllMetasServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.GetAllMetasResponseRecord;

import java.util.UUID;

public interface iGetAllMetasService {
    public GetAllMetasResponseRecord getAllMetas(UUID groupId) throws Exception;
}
