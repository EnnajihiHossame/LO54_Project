package com.utbm.lo54;

import com.utbm.lo54.Util.Utils;
import core.DAO.ClientDao;
import core.DAO.CourseSessionDao;
import core.Entity.ClientEntity;
import core.Entity.CourseEntity;
import core.Entity.CourseSessionEntity;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ennajihihoussame on 12/06/2017.
 */
public class SubscriptionCommitServlet extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);

        String first_name = request.getParameter(Utils.CLIENT_FIRST_NAME);
        String last_name = request.getParameter(Utils.CLIENT_LAST_NAME);
        String address = request.getParameter(Utils.CLIENT_ADDRESS);
        String phone_number = request.getParameter(Utils.CLIENT_PHONE_NUMBER);
        String email = request.getParameter(Utils.CLIENT_MAIL);
        System.out.print(first_name +" "+last_name+" "+address+" "+phone_number+" "+email);
        int course_session_id = Integer.parseInt(request.getParameter(Utils.FILTER_ID_COURSE_SESSION));
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        CourseSessionEntity courseSessionEntity = (CourseSessionEntity) courseSessionDao.getEntity(course_session_id);
        ClientDao clientDao = new ClientDao();
        ClientEntity clientEntity = new ClientEntity(last_name, first_name, address, phone_number, email, courseSessionEntity);
        clientDao.insertEntity(clientEntity);


        Boolean subscription_confirmed = false;
        if (clientDao.getEntity(clientEntity.getIdClient()) != null) {
            subscription_confirmed = true;
        } else {
            subscription_confirmed = false;
        }

        request.setAttribute(Utils.ATTRIBUTE_RESULT, subscription_confirmed);
        request.getRequestDispatcher(Utils.PATH_INSCRIPTION).forward(request, response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
