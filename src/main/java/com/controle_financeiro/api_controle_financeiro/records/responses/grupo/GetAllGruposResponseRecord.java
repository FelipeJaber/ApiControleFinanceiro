package com.controle_financeiro.api_controle_financeiro.records.responses.grupo;

import com.controle_financeiro.api_controle_financeiro.models.GrupoModel;

import java.util.List;

public record GetAllGruposResponseRecord(String response, List<GrupoModel> grupos) {
}
