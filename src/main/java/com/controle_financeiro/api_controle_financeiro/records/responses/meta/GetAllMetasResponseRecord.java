package com.controle_financeiro.api_controle_financeiro.records.responses.meta;

import com.controle_financeiro.api_controle_financeiro.models.MetaModel;

import java.util.List;

public record GetAllMetasResponseRecord(List<MetaModel> metas) {
}
