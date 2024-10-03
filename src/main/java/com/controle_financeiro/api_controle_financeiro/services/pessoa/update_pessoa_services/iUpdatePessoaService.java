package com.controle_financeiro.api_controle_financeiro.services.pessoa.update_pessoa_services;

import com.controle_financeiro.api_controle_financeiro.records.requests.pessoa.UpdatePessoaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.pessoas.UpdatePessoaResponseRecord;
import org.springframework.stereotype.Service;

@Service
public interface iUpdatePessoaService {
    public UpdatePessoaResponseRecord updatePessoa(UpdatePessoaRecord updatePessoaRecord)throws Exception;
}
