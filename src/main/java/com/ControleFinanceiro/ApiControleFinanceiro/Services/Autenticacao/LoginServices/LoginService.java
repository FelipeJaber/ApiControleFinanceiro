package com.ControleFinanceiro.ApiControleFinanceiro.Services.Autenticacao.LoginServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.LoginRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Autenticacao.LoginResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iPessoaRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements iLoginService{
    iPessoaRepository pessoaRepository;
    TokenService tokenService;

    @Autowired
    public LoginService(iPessoaRepository pessoaRepository, TokenService tokenService) {
        this.pessoaRepository = pessoaRepository;
        this.tokenService = tokenService;
    }

    @Override
    public LoginResponseRecord login(LoginRecord loginRecord) throws Exception {
        PessoaModel user = getPessoa(loginRecord);
        user = getUserFromDataBase(user);
        String token = generateToken(user);
        return createLoginResponse(token);
    }

    private PessoaModel getUserFromDataBase(PessoaModel user) throws Exception{
        Optional<PessoaModel> dbUser = pessoaRepository.findByCpfPessoaAndEmailPessoa(user.getCpfPessoa(), user.getEmailPessoa());
        if(dbUser.isEmpty())throw new Exception(ExceptionsEnum.ACCESS_DENIED_INVALID_CREDENTIALS.name());
        return dbUser.get();
    }

    private PessoaModel getPessoa(LoginRecord loginRecord) throws Exception{
        return new PessoaModel(loginRecord);
    }

    private String generateToken(PessoaModel user){
        return tokenService.generateToken(user.getIdPessoa());
    }

    private LoginResponseRecord createLoginResponse(String token){
        return new LoginResponseRecord("Success", token);
    }
}
