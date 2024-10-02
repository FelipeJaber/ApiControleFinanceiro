package com.ControleFinanceiro.ApiControleFinanceiro.Services.Autenticacao.RegisterServices;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Requests.Autenticacao.RegisterRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Records.Responses.Autenticacao.RegisterResponseRecord;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iPessoaRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Token.TokenService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoCPF.iValidacaoCPFService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoEmail.iValidacaoEmailService;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Validacoes.ValidacaoTelefone.iValidacaoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements iRegisterService{

    iValidacaoCPFService validacaoCPFService;
    iValidacaoEmailService validacaoEmailService;
    iValidacaoTelefoneService validacaoTelefoneService;
    TokenService tokenService;
    iPessoaRepository pessoaRepository;

    @Autowired
    public RegisterService(iValidacaoCPFService validacaoCPFService, iValidacaoEmailService validacaoEmailService, iValidacaoTelefoneService validacaoTelefoneService, TokenService tokenService, iPessoaRepository pessoaRepository) {
        this.validacaoCPFService = validacaoCPFService;
        this.validacaoEmailService = validacaoEmailService;
        this.validacaoTelefoneService = validacaoTelefoneService;
        this.tokenService = tokenService;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public RegisterResponseRecord register(RegisterRecord registerRecord) throws Exception {

        PessoaModel user = createNewPessoa(registerRecord);
        user = saveUserCredentials(user);
        String token = generateToken(user);

        return createRegisterResponse(token);
    }

    private PessoaModel createNewPessoa(RegisterRecord registerRecord) throws Exception {
        return new PessoaModel(registerRecord);
    }

    private PessoaModel saveUserCredentials(PessoaModel user) throws Exception{
        try {
            return pessoaRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            String message = e.getMostSpecificCause().getMessage();

            if (message.contains("cpf")) {
                throw new Exception(ExceptionsEnum.DUPLICATE_CPF.name());
            } else if (message.contains("email")) {
                throw new Exception(ExceptionsEnum.DUPLICATE_EMAIL.name());
            } else if (message.contains("telefone")) {
                throw new Exception(ExceptionsEnum.DUPLICATE_TELEFONE.name());
            } else {
                throw new Exception(ExceptionsEnum.DUPLICATE_DATA.name());
            }
        }
    }

    private String generateToken(PessoaModel user){
        return tokenService.generateToken(user.getIdPessoa());
    }

    private RegisterResponseRecord createRegisterResponse(String token){
        return new RegisterResponseRecord("Success", token);
    }
}
