package com.jproject.desafio.resource;

import com.jproject.desafio.model.PessoaFisica;
import com.jproject.desafio.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/login")
public class LoginResource {

     @Inject
     LoginService loginService;

     private static Logger log = LoggerFactory.getLogger(LoginResource.class);

     @POST
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public Response login(@FormParam("alun_cpf") String alun_cpf, @FormParam("usu_pwd") final String usu_pwd) {
          alun_cpf = alun_cpf.replaceAll("[^0-9]", "");

          if(alun_cpf.isBlank() || alun_cpf.isEmpty() || usu_pwd.isBlank() || usu_pwd.isEmpty())
               return Response.status(Response.Status.BAD_REQUEST).build();

          log.info("Informações : {} e {}", alun_cpf,usu_pwd);
          return loginService.login(alun_cpf,usu_pwd);
     }
}
