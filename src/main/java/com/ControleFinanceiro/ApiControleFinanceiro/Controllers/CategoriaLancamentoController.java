package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.CategoriaLancamentoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorialancamento")
public class CategoriaLancamentoController {
    @GetMapping("/getall")
    public ResponseEntity<?> getAllCategoriaLancamento(){
        return ResponseEntity.ok(CategoriaLancamentoEnum.values());
    }
}
