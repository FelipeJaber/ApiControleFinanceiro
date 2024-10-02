package com.ControleFinanceiro.ApiControleFinanceiro.Repositories;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.LancamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iLancamentoRepository extends JpaRepository<LancamentoModel, UUID> {
}
