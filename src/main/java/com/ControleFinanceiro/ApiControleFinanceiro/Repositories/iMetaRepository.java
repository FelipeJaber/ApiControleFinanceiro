package com.ControleFinanceiro.ApiControleFinanceiro.Repositories;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.MetaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iMetaRepository extends JpaRepository<MetaModel, UUID> {
}
