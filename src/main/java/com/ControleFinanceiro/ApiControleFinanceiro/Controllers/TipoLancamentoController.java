package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.TipoLancamentoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipolancamento")
public class TipoLancamentoController {

    @GetMapping("/getall")
    public ResponseEntity<?> getAllTiposLancamento(){
        return ResponseEntity.ok(TipoLancamentoEnum.values());
    }
}
