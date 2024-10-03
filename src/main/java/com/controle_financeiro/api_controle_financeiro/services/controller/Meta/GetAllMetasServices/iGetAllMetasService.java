package com.controle_financeiro.api_controle_financeiro.services.controller.Meta.GetAllMetasServices;

import com.controle_financeiro.api_controle_financeiro.records.responses.meta.GetAllMetasResponseRecord;

import java.util.UUID;

public interface iGetAllMetasService {
    public GetAllMetasResponseRecord getAllMetas(UUID groupId) throws Exception;
}
