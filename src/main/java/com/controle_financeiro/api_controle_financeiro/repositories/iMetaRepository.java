package com.controle_financeiro.api_controle_financeiro.repositories;

import com.controle_financeiro.api_controle_financeiro.models.MetaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iMetaRepository extends JpaRepository<MetaModel, UUID> {
}
