package com.jproject.desafio.resource;

import com.jproject.desafio.model.Usuarios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosResource {

    @GET
    public List<Usuarios> findUsers(){
        Usuarios usuarios = new Usuarios();
        return usuarios.findUsu();
    }

}
