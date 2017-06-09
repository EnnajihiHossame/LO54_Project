package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.CourseSessionDao;
import core.Entity.IEntity;

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


        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<IEntity> listCoursesSession = courseSessionDao.getEntities();


        request.setAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);
        request.setAttribute(Utils.ATTRIBUTE_SENTENCE, "There is " + listCoursesSession.size() + " courses with this filter");

        request.getRequestDispatcher(Utils.PATH_FILTER_DEFAULT).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
