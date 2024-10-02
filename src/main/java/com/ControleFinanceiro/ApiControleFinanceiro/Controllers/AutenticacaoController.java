package com.ControleFinanceiro.ApiControleFinanceiro.Controllers;

import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.LoginRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.RegisterRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Autenticacao.LoginServices.iLoginService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Controller.Autenticacao.RegisterServices.iRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {

    iLoginService loginService;
    iRegisterService registerService;

    @Autowired
    public AutenticacaoController(iLoginService loginService, iRegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRecord registerRecord) throws Exception {
        return ResponseEntity.ok(registerService.register(registerRecord));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRecord loginRecord) throws Exception {
        return ResponseEntity.ok(loginService.login(loginRecord));
    }

}
