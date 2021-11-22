package com.jproject.desafio.service;

import com.jproject.desafio.model.PessoaFisica;
import com.jproject.desafio.util.GenerateToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginService {

   private static Logger log = LoggerFactory.getLogger(LoginService.class);

    @Inject
    GenerateToken generateToken;

    public Response login(String alun_cpf, String usu_pwd){
       PessoaFisica pessoaFisica = new PessoaFisica();

       Optional <PessoaFisica> optional = pessoaFisica.findByOptional(alun_cpf);

        if(optional.isPresent()){

            if(!optional.get().getUsuarios().getUsu_pwd().equals(usu_pwd)) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

        return Response.status(Response.Status.OK).entity(optional.get().getAlun_id()).build();



        }

        return Response.status(Response.Status.FORBIDDEN).entity("Erro tente novamente").build();
    }
}
