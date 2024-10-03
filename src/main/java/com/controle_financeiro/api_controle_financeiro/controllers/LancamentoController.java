package com.controle_financeiro.api_controle_financeiro.controllers;

import com.controle_financeiro.api_controle_financeiro.records.requests.lancamento.CreateLancamentoRecord;
import com.controle_financeiro.api_controle_financeiro.records.requests.lancamento.UpdateLancamentoRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.autenticacao.RegisterResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.CreateLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.DeleteLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.GetAllLancamentosResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.lancamento.UpdateLancamentoResponseRecord;
import com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.CreateLancamentoServices.iCreateLancamentoService;
import com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.GetAllLancamentosServices.iGetAllLancamentosService;
import com.controle_financeiro.api_controle_financeiro.services.controller.Lancamento.UpdateLancamentoServices.iUpdateLancamentoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = CreateLancamentoResponseRecord.class))),
    })
    @PostMapping("/create")
    ResponseEntity<?> createLancamento(@RequestBody @Valid CreateLancamentoRecord createLancamentoRecord)throws Exception{
        return ResponseEntity.ok(createLancamentoService.createLancamento(createLancamentoRecord));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateLancamentoResponseRecord.class))),
    })
    @PutMapping("/update")
    ResponseEntity<?> updateLancamento(@RequestBody @Valid UpdateLancamentoRecord updateLancamentoRecord)throws Exception{
        return ResponseEntity.ok(updateLancamentoService.updateLancamento(updateLancamentoRecord));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = GetAllLancamentosResponseRecord.class))),
    })
    @GetMapping("/getall/{id_grupo}")
    ResponseEntity<?> getAllLancamentos(@PathVariable @Valid UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllLancamentosService.getAllLancamentos(id_grupo));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = DeleteLancamentoResponseRecord.class))),
    })
    @DeleteMapping("/delete/{id_grupo}")
    ResponseEntity<?> deleteLancamento(@PathVariable @Valid UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllLancamentosService.getAllLancamentos(id_grupo));
    }
}
