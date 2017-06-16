package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.CourseSessionDao;
import core.Entity.CourseSessionEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ennajihihoussame on 12/06/2017.
 */
public class SubscriptionFormServlet extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);


        CourseSessionDao courseSessionDao = new CourseSessionDao();
        CourseSessionEntity courseSession = (CourseSessionEntity) courseSessionDao.getEntity(Integer.parseInt(request.getParameter(Utils.SELECTED_ID_COURSE_SESSION)));

        request.setAttribute(Utils.ATTRIBUTE_COURSE_SESSION, courseSession);

        request.getRequestDispatcher(Utils.PATH_INSCRIPTION_FORM).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
