package com.jproject.desafio.util;
import java.util.Arrays;
import java.util.HashSet;
import com.jproject.desafio.model.Usuarios;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.JsonWebToken;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GenerateToken {
    @Inject
    JsonWebToken jwt;

    public String generateTokenJWT(Usuarios  usuarios) {

        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn(usuarios.getUsu_login())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .sign();
        System.out.println(token);
        return token;
    }
}