package com.jproject.desafio.util;
import java.util.Arrays;
import java.util.HashSet;

import com.jproject.desafio.model.PessoaFisica;
import com.jproject.desafio.model.Usuarios;
import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenerateToken {

    public String generateTokenJWT(PessoaFisica pessoaFisica) {
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn(pessoaFisica.getAlun_email())
                        .groups(new HashSet<>(Arrays.asList("User")))
                        .sign();
        System.out.println(token);
        return token;
    }
}