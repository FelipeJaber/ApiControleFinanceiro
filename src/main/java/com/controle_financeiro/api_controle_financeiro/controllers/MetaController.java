package com.controle_financeiro.api_controle_financeiro.controllers;

import com.controle_financeiro.api_controle_financeiro.records.requests.meta.CreateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.requests.meta.UpdateMetaRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.autenticacao.RegisterResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.CreateMetaResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.GetAllMetasResponseRecord;
import com.controle_financeiro.api_controle_financeiro.records.responses.meta.UpdateMetaResponseRecord;
import com.controle_financeiro.api_controle_financeiro.services.controller.Meta.CreateMetaServices.iCreateMetaService;
import com.controle_financeiro.api_controle_financeiro.services.controller.Meta.GetAllMetasServices.iGetAllMetasService;
import com.controle_financeiro.api_controle_financeiro.services.controller.Meta.UpdateMetaServices.iUpdateMetaService;
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
@RequestMapping("/api/meta")
public class MetaController {
    iCreateMetaService createMetaService;
    iUpdateMetaService updateMetaService;
    iGetAllMetasService getAllMetasService;

    @Autowired
    public MetaController(iCreateMetaService createMetaService, iUpdateMetaService updateMetaService, iGetAllMetasService getAllMetasService) {
        this.createMetaService = createMetaService;
        this.updateMetaService = updateMetaService;
        this.getAllMetasService = getAllMetasService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = CreateMetaResponseRecord.class))),
    })
    @PostMapping("/create")
    ResponseEntity<?> createMeta(@RequestBody @Valid CreateMetaRecord createMetaRecord)throws Exception{
        return ResponseEntity.ok(createMetaService.createMeta(createMetaRecord));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateMetaResponseRecord.class))),
    })
    @PutMapping("/update")
    ResponseEntity<?> updateMeta(@RequestBody @Valid UpdateMetaRecord updateMetaRecord)throws Exception{
        return ResponseEntity.ok(updateMetaService.updateMeta(updateMetaRecord));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = GetAllMetasResponseRecord.class))),
    })
    @GetMapping("/getall/{id_grupo}")
    ResponseEntity<?> getAllMetas(@Valid @PathVariable UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllMetasService.getAllMetas(id_grupo));
    }
}
