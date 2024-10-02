package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.CreateMetaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.CreateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Meta.CreateMetaResponseRecord;

public interface iCreateMetaService {
 public CreateMetaResponseRecord createMeta(CreateMetaRecord createMetaRecord) throws Exception;
}
