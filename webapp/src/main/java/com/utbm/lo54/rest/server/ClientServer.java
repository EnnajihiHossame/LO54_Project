package com.utbm.lo54.rest.server;

import core.DAO.ClientDao;
import core.Entity.ClientEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ennajihihoussame on 21/06/2017.
 */

@Path("/client")
public class ClientServer {

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClients(){
        ClientDao clientDao = new ClientDao();
        List<ClientEntity> clientList = (List<ClientEntity>)(List<?>) clientDao.getEntities();

        return clientList.toString();
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{client}")
    public String getClientById(@PathParam("client") int id)
    {
        ClientDao clientDao = new ClientDao();
        ClientEntity clientEntity = (ClientEntity) clientDao.getEntity(id);

        if(clientEntity==null)
        {
            throw new RuntimeException("Get: Client with " + id +  " not found");
        }

        return clientEntity.toString();
    }


    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStudentRecord(String student){
        String result = "Record entered: "+ student;
        return Response.status(201).entity(result).build();
    }
}