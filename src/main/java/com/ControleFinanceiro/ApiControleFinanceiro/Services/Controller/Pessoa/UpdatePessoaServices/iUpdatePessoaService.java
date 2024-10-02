package com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Pessoa.UpdatePessoaServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.UpdatePessoaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Pessoas.UpdatePessoaResponseRecord;
import org.springframework.stereotype.Service;

@Service
public interface iUpdatePessoaService {
    public UpdatePessoaResponseRecord updatePessoa(UpdatePessoaRecord updatePessoaRecord)throws Exception;
}
