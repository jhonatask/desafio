package com.jproject.desafio.resource;

import com.jproject.desafio.model.Matricula;
import com.jproject.desafio.model.Usuarios;
import com.jproject.desafio.service.ReMatriculaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


@Path("/rematricula")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReMatriculaResource {

    @Inject
    ReMatriculaService reMatriculaService;

    @GET
    public Response getMatriculas(@QueryParam("alun_id") final String alun_id) {
        try {
            if(alun_id.isBlank() || alun_id.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Usuario não Informado").build();
            }
            return  reMatriculaService.getMatriculaUsuId(alun_id);

        }catch (Exception ex){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }


    }


}
