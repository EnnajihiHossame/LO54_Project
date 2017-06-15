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
import java.util.Calendar;
import java.util.List;

/**
 * Created by ennajihihoussame on 15/06/2017.
 */
public class LandingFilterByDate extends HttpServlet {

    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Utils.CONTENT_TYPE);

        String date = request.getParameter("filter_date");
        System.out.println(date);
        String splitedDate [] = date.split("-");
        System.out.println(splitedDate[0]);
        System.out.println(splitedDate[1]);
        System.out.println(splitedDate[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(splitedDate[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(splitedDate[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitedDate[0]));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Timestamp startDate = new Timestamp(calendar.getTimeInMillis());
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitedDate[0]) + 1);
        Timestamp endDate = new Timestamp(calendar.getTimeInMillis());



        // get list of course sessions
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<IEntity> listCoursesSession = courseSessionDao.getEntitiesByTimeStamp(startDate, endDate);
        request.setAttribute(Utils.ATTRIBUTE_LIST_COURSES_SESSION, listCoursesSession);


        //get list of locations from DB
        LocationDao locationDao = new LocationDao();
        List<IEntity> listLocation = locationDao.getEntities();
        request.setAttribute(Utils.ATTRIBUTE_LIST_LOCATION, listLocation);

        request.setAttribute(Utils.CURRENT_FILTER_TYPE, "date");
        request.setAttribute(Utils.CURRENT_FILTER_VALUE, date);
        request.getRequestDispatcher(Utils.PATH_FILTER_DEFAULT).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}