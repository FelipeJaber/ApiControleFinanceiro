package com.controle_financeiro.api_controle_financeiro.repositories;

import com.controle_financeiro.api_controle_financeiro.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface iPessoaRepository extends JpaRepository<PessoaModel, UUID> {
    Optional<PessoaModel> findByCpfPessoaAndEmailPessoa(String cpfPessoa, String emailPessoa);

}
