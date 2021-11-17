package com.jproject.desafio.service;

import com.jproject.desafio.model.PessoaFisica;
import com.jproject.desafio.util.GenerateToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class LoginService {

   private static Logger log = LoggerFactory.getLogger(LoginService.class);

    @Inject
    GenerateToken generateToken;

    public Response login(String alun_cpf, String usu_pwd){
       PessoaFisica pessoaFisica = new PessoaFisica();

       Optional <PessoaFisica> optional = pessoaFisica.findByOptional(alun_cpf);



        if(optional.isPresent()){
            log.info(optional.get().getUsuarios().getUsu_pwd());
            //VALIDAR A MASCARA DA SENHA DIMINUIR VISIBILIDADE
            if(!optional.get().getUsuarios().getUsu_pwd().equals(usu_pwd)) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

//            return Response.status(Response.Status.OK).entity("token").build();
           return Response.status(Response.Status.ACCEPTED).build();
        }

        return Response.status(Response.Status.FORBIDDEN).build();
    }
}
