package com.utbm.lo54.rest.server;

import core.DAO.CourseSessionDao;
import core.DAO.LocationDao;
import core.Entity.CourseSessionEntity;
import core.Entity.LocationEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ennajihihoussame on 21/06/2017.
 */
@Path("/location")
public class LocationServer {

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocations(){
        LocationDao locationDao = new LocationDao();
        List<LocationEntity> locationList = (List<LocationEntity>)(List<?>) locationDao.getEntities();
        return locationList.toString();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStudentRecord(String student){
        String result = "Record entered: "+ student;
        return Response.status(201).entity(result).build();
    }
}