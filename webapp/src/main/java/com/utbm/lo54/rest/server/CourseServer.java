package com.utbm.lo54.rest.server;

import core.DAO.CourseDao;
import core.Entity.CourseEntity;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ennajihihoussame on 21/06/2017.
 */


@Path("/course")
public class CourseServer {

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCourses(){
        CourseDao courseDao = new CourseDao();
        List<CourseEntity> courseList = (List<CourseEntity>)(List<?>) courseDao.getEntities();
        return courseList.toString();
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{course}")
    public String getCourseById(@PathParam("course") String id)
    {
        CourseDao courseDao = new CourseDao();
        CourseEntity courseEntity = (CourseEntity) courseDao.getEntity(id);

        if(courseEntity==null)
        {
            throw new RuntimeException("Get: Client with " + id +  " not found");
        }

        return courseEntity.toString();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStudentRecord(String student){
        String result = "Record entered: "+ student;
        return Response.status(201).entity(result).build();
    }
}