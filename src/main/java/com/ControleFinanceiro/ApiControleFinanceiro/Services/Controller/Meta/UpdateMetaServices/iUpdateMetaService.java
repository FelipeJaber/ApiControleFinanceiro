package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.UpdateMetaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.UpdateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.UpdateMetaResponseRecord;

public interface iUpdateMetaService {
    public UpdateMetaResponseRecord updateMeta(UpdateMetaRecord updateMetaRecord) throws Exception;
}
