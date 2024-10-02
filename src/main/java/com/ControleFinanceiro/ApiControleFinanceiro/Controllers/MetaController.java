package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.CreateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Meta.UpdateMetaRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.CreateMetaServices.iCreateMetaService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.GetAllMetasServices.iGetAllMetasService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Meta.UpdateMetaServices.iUpdateMetaService;
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

    @PostMapping("/create")
    ResponseEntity<?> createMeta(@RequestBody @Valid CreateMetaRecord createMetaRecord)throws Exception{
        return ResponseEntity.ok(createMetaService.createMeta(createMetaRecord));
    }

    @PutMapping("/update")
    ResponseEntity<?> updateMeta(@RequestBody @Valid UpdateMetaRecord updateMetaRecord)throws Exception{
        return ResponseEntity.ok(updateMetaService.updateMeta(updateMetaRecord));
    }

    @GetMapping("/getall/{id_grupo}")
    ResponseEntity<?> getAllMetas(@Valid @PathVariable UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getAllMetasService.getAllMetas(id_grupo));
    }
}
