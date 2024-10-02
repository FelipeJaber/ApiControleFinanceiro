package com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security;

import com.ControleFinanceiro.ApiControleFinanceiro.Models.PessoaModel;

import java.util.UUID;

public class UserCredentials {

    private static final ThreadLocal<UserCredentials> session = new ThreadLocal<>();
    private PessoaModel userModel;

    private UserCredentials(PessoaModel user) {
        this.userModel = user;
    }

    public static void setInstance(PessoaModel user) {
        session.set(new UserCredentials(user));
    }

    public static UserCredentials getInstance() throws Exception {
        UserCredentials userCredentials = session.get();
        if (userCredentials == null) {
            throw new Exception("UserCredentials has not been initialized yet.");
        }
        return userCredentials;
    }

    public PessoaModel getUserModel() throws Exception {
        if (userModel == null) throw new Exception("Invalid user id");
        return userModel;
    }

    public static void clear() {
        session.remove();
    }
}
