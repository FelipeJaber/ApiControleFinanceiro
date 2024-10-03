package com.controle_financeiro.api_controle_financeiro.services.controller.Meta.UpdateMetaServices;

import com.controle_financeiro.api_controle_financeiro.records.requests.meta.UpdateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.UpdateMetaResponseRecord;

public interface iUpdateMetaService {
    public UpdateMetaResponseRecord updateMeta(UpdateMetaRecord updateMetaRecord) throws Exception;
}
