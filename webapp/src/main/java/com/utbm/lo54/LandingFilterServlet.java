package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.CourseSessionDao;
import core.DAO.LocationDao;
import core.Entity.IEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ennajihihoussame on 15/06/2017.
 */
public class LandingFilterServlet extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);

        // get list of course sessions
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        int location_id = Integer.parseInt(request.getParameter("filter_location"));
        String course_title = request.getParameter("filter_search");
        Timestamp date = new Timestamp(System.currentTimeMillis());
        System.out.println(location_id +" "+ course_title+" "+ date);
        List<IEntity> listCoursesSession = courseSessionDao.getEntitiesByFilters(location_id, date, course_title);
        request.setAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);

        //get list of locations from DB

        LocationDao locationDao = new LocationDao();
        List<IEntity> listLocation = locationDao.getEntities();
        request.setAttribute(Utils.ATTRIBUTE_LIST_LOCATION, listLocation);


        request.getRequestDispatcher(Utils.PATH_FILTER_DEFAULT).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}