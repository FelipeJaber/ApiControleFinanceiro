package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento.CreateLancamentoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Lancamento.UpdateLancamentoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.CreateLancamentoServices.iCreateLancamentoService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.GetAllLancamentosServices.iGetAllLancamentosService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Lancamento.UpdateLancamentoServices.iUpdateLancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    iUpdateLancamentoService updateLancamentoService;
    iCreateLancamentoService createLancamentoService;
    iGetAllLancamentosService getAllLancamentosService;

    @Autowired
    public LancamentoController(iUpdateLancamentoService updateLancamentoService, iCreateLancamentoService createLancamentoService, iGetAllLancamentosService getAllLancamentosService) {
        this.updateLancamentoService = updateLancamentoService;
        this.createLancamentoService = createLancamentoService;
        this.getAllLancamentosService = getAllLancamentosService;
    }

    @PostMapping("/create")
    ResponseEntity<?> createLancamento(@RequestBody @Valid CreateLancamentoRecord createLancamentoRecord)throws Exception{
        return ResponseEntity.ok(createLancamentoService.createLancamento(createLancamentoRecord));
    }

    @PutMapping("/update")
    ResponseEntity<?> updateLancamento(@RequestBody @Valid UpdateLancamentoRecord updateLancamentoRecord)throws Exception{
        return ResponseEntity.ok(updateLancamentoService.updateLancamento(updateLancamentoRecord));
    }

    @GetMapping("/getall/{id_grupo}")
    ResponseEntity<?> getAllLancamentos(@PathVariable @Valid UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllLancamentosService.getAllLancamentos(id_grupo));
    }

    @DeleteMapping("/delete/{id_grupo}")
    ResponseEntity<?> deleteLancamento(@PathVariable @Valid UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllLancamentosService.getAllLancamentos(id_grupo));
    }
}
