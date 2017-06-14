package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.CourseSessionDao;
import core.DAO.LocationDao;
import core.Entity.IEntity;
import core.Entity.LocationEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ennajihihoussame on 09/06/2017.
 */

public class LandingServlet extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);

        // get list of course sessions
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<IEntity> listCoursesSession = courseSessionDao.getEntities();
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
