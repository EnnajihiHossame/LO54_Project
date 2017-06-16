package core;

import core.DAO.ClientDao;
import core.DAO.CourseDao;
import core.DAO.CourseSessionDao;
import core.DAO.LocationDao;
import core.Entity.ClientEntity;
import core.Entity.CourseEntity;
import core.Entity.CourseSessionEntity;
import core.Entity.IEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<IEntity> coursesession_list = courseSessionDao.getEntitiesByLocationId(2);
        System.out.println(coursesession_list.toString());


    }
}
