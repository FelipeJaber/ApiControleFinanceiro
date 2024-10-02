package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.CreatePessoaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.UpdatePessoaRecord;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @PutMapping("/update")
    public ResponseEntity<?> updatePessoa(@RequestBody @Valid UpdatePessoaRecord updatePessoaRecord) throws Exception {
        return null;
    }

    @DeleteMapping("/delete/{cpf_pessoa}")
    public ResponseEntity<?> deletePessoa(@PathVariable String cpf_pessoa) throws Exception {
        return null;
    }

}
