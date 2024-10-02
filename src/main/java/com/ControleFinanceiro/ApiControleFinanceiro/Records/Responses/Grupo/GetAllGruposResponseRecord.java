package com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Grupo;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;

import java.util.List;

public record GetAllGruposResponseRecord(String response, List<GrupoModel> grupos) {
}
