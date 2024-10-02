package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.CreateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Grupo.UpdateGrupoRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.CreateGrupoServices.iCreateGrupoService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.DeleteGrupoServices.iDeleteGrupoService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.GetAllGruposServices.iGetAllGruposService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.GetGrupoServices.iGetGrupoService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Grupo.UpdateGrupoServices.iUpdateGrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    iCreateGrupoService createGrupoService;
    iDeleteGrupoService deleteGrupoService;
    iGetAllGruposService getAllGruposService;
    iGetGrupoService getGrupoService;
    iUpdateGrupoService updateGrupoService;

    @Autowired
    public GrupoController(iCreateGrupoService createGrupoService, iDeleteGrupoService deleteGrupoService, iGetAllGruposService getAllGruposService, iGetGrupoService getGrupoService, iUpdateGrupoService updateGrupoService) {
        this.createGrupoService = createGrupoService;
        this.deleteGrupoService = deleteGrupoService;
        this.getAllGruposService = getAllGruposService;
        this.getGrupoService = getGrupoService;
        this.updateGrupoService = updateGrupoService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGrupo(@Valid CreateGrupoRecord createGrupoRecord)throws Exception{
        return ResponseEntity.ok(createGrupoService.createGrupo(createGrupoRecord));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateGrupo(@Valid UpdateGrupoRecord updateGrupoRecord)throws Exception{
        return ResponseEntity.ok(updateGrupoService.updateGrupo(updateGrupoRecord));
    }

    @DeleteMapping("/delete/{id_grupo}")
    public ResponseEntity<?> deleteGrupo(@Valid @PathVariable UUID id_grupo)throws Exception{
        return ResponseEntity.ok(deleteGrupoService.DeleteGrupo(id_grupo));
    }

    @GetMapping("/get/{id_grupo}")
    public ResponseEntity<?> getGrupo(@Valid @PathVariable UUID id_grupo)throws Exception{
        return ResponseEntity.ok(getGrupoService.getGrupo(id_grupo));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllGrupos()throws Exception{
        return ResponseEntity.ok(getAllGruposService.getAllGrupos());
    }
}
