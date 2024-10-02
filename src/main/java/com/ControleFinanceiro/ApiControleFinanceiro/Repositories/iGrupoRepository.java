package com.ControleFinanceiro.ApiControleFinanceiro.Repositories;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.GrupoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iGrupoRepository extends JpaRepository<GrupoModel, UUID> {
}
