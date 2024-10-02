package com.ControleFinanceiro.ApiControleFinanceiro.Configurations.Security;

import java.util.UUID;

public class UserCredentials {

    private static final ThreadLocal<UserCredentials> session = new ThreadLocal<>();
    private UUID userId;

    private UserCredentials(UUID userId) {
        this.userId = userId;
    }

    public static void setInstance(UUID userId) {
        session.set(new UserCredentials(userId));
    }

    public static UserCredentials getInstance() throws Exception {
        UserCredentials userCredentials = session.get();
        if (userCredentials == null) {
            throw new Exception("UserCredentials has not been initialized yet.");
        }
        return userCredentials;
    }

    public UUID getUserId() throws Exception {
        if (userId == null) throw new Exception("Invalid user id");
        return userId;
    }

    public static void clear() {
        session.remove();  // Limpa após a requisição
    }
}
