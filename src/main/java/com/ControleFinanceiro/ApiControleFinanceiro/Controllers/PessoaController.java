package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Pessoa.UpdatePessoaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Pessoa.UpdatePessoaServices.iUpdatePessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    iUpdatePessoaService updatePessoaService;

    @Autowired
    public PessoaController(iUpdatePessoaService updatePessoaService) {
        this.updatePessoaService = updatePessoaService;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePessoa(@RequestBody @Valid UpdatePessoaRecord updatePessoaRecord) throws Exception {
        return ResponseEntity.ok(updatePessoaService.updatePessoa(updatePessoaRecord));
    }

}
