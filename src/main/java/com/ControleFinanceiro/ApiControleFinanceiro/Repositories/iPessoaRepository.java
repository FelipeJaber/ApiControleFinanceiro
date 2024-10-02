package com.ControleFinanceiro.ApiControleFinanceiro.Repositories;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface iPessoaRepository extends JpaRepository<PessoaModel, UUID> {
    Optional<PessoaModel> findByCpfPessoaAndEmailPessoa(String cpfPessoa, String emailPessoa);

}
