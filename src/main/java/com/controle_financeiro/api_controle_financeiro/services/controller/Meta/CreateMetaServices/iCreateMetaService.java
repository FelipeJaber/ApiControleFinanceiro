package com.controle_financeiro.api_controle_financeiro.services.controller.Meta.CreateMetaServices;

import com.controle_financeiro.api_controle_financeiro.records.requests.meta.CreateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.CreateMetaResponseRecord;

public interface iCreateMetaService {
 public CreateMetaResponseRecord createMeta(CreateMetaRecord createMetaRecord) throws Exception;
}
