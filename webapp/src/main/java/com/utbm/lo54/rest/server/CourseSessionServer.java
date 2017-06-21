package com.utbm.lo54.rest.server;

import core.DAO.CourseSessionDao;
import core.Entity.CourseSessionEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ennajihihoussame on 21/06/2017.
 */
@Path("/courseSession")
public class CourseSessionServer {

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCourseSessions() {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<CourseSessionEntity> coursesessionList = (List<CourseSessionEntity>) (List<?>) courseSessionDao.getEntities();
        return coursesessionList.toString();
    }

    @GET
    @Path("/id/{coursesession}")
    public String getCourseSessionById(@PathParam("coursesession") int id) {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        CourseSessionEntity courseSessionEntity = (CourseSessionEntity) courseSessionDao.getEntity(id);

        if (courseSessionEntity == null) {
            throw new RuntimeException("Get: Client with " + id + " not found");
        }

        return courseSessionEntity.toString();
    }
    @GET
    @Path("/location/{location}")
    public String getCourseSessionBylocation(@PathParam("location") int location) {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<CourseSessionEntity> courseSessionEntities = (List<CourseSessionEntity>) (List<?>)courseSessionDao.getEntitiesByLocationId(location);

        if (courseSessionEntities == null) {
            throw new RuntimeException("Get: Client with " + location + " not found");
        }

        return courseSessionEntities.toString();
    }


    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postStudentRecord(String student) {
        String result = "Record entered: " + student;
        return Response.status(201).entity(result).build();
    }
}