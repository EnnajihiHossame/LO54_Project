package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.CourseSessionDao;
import core.DAO.LocationDao;
import core.Entity.IEntity;
import core.Entity.LocationEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ennajihihoussame on 15/06/2017.
 */
public class LandingFilterByLocation extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);

        // get list of course sessions
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        int location_id = Integer.parseInt(request.getParameter("filter_location"));
        System.out.println(location_id);
        List<IEntity> listCoursesSession = courseSessionDao.getEntitiesByLocationId(location_id);
        request.setAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);


        //get list of locations from DB

        LocationDao locationDao = new LocationDao();
        List<IEntity> listLocation = locationDao.getEntities();
        request.setAttribute(Utils.ATTRIBUTE_LIST_LOCATION, listLocation);

        LocationEntity le = (LocationEntity) locationDao.getEntity(location_id);
        String city = le.getCity();

        request.setAttribute(Utils.CURRENT_FILTER_TYPE, "Lieu");
        request.setAttribute(Utils.CURRENT_FILTER_VALUE, city);
        request.getRequestDispatcher(Utils.PATH_LANDING).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}