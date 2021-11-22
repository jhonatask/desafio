package com.jproject.desafio.service;

import com.jproject.desafio.model.Matricula;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReMatriculaService {

    public Response getMatriculaUsuId(String alun_id) {
        Matricula matricula = new Matricula();
        Optional<Matricula> mat = matricula.findByOptional(Long.parseLong(alun_id));
        System.out.println(mat.get());

        return Response.status(Response.Status.OK).entity(mat.get()).build();
    }

        ///return Response.status(Response.Status.FORBIDDEN).build();
}
