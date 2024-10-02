package com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security;

import com.ControleFinanceiro.ApiControleFinanceiro.Enums.ExceptionsEnum;
import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;
import com.ControleFinanceiro.ApiControleFinanceiro.Repositories.iPessoaRepository;
import com.ControleFinanceiro.ApiControleFinanceiro.Services.Token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    TokenService tokenService;
    iPessoaRepository pessoaRepository;

    @Autowired
    public SecurityFilter(TokenService tokenService, iPessoaRepository pessoaRepository) {
        this.tokenService = tokenService;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null && !token.isEmpty()) {
            var login = tokenService.validateToken(token);

            UUID userID = null;
            try {
                userID = UUID.fromString(login);
                UserCredentials.setInstance(userID);
            } catch (Exception e) {
                response.sendError(ExceptionsEnum.ACCESS_DENIED_INVALID_CREDENTIALS.getError_code(), ExceptionsEnum.ACCESS_DENIED_INVALID_CREDENTIALS.getError_text());
            }

            if (userID != null) {

                Optional<PessoaModel> cadastro_pessoa_db = pessoaRepository.findById(userID);
                if(cadastro_pessoa_db.isPresent()){

                    var authentication = new UsernamePasswordAuthenticationToken(cadastro_pessoa_db.get().getUsername(), null, cadastro_pessoa_db.get().getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }

        }

        filterChain.doFilter(request, response);
    }


    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
