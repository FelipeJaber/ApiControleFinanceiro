package com.controle_financeiro.api_controle_financeiro.services.relatorios;

import com.controle_financeiro.api_controle_financeiro.records.responses.relatorios.GetSaldoPerGrupoResponseRecord;

import java.util.UUID;

public interface iRelatoriosService {
    public GetSaldoPerGrupoResponseRecord getSaldoPerGrupo(UUID idGrupo) throws Exception;
}
