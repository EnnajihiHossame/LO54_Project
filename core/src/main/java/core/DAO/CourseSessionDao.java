package core.DAO;

import core.Entity.CourseEntity;
import core.Entity.CourseSessionEntity;
import core.Entity.IEntity;
import core.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */
public class CourseSessionDao implements IDao {


    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }


    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((Integer) id, CourseSessionEntity.class.getCanonicalName(), entity);
    }


    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((Integer) id, CourseSessionEntity.class.getCanonicalName());
    }


    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((Integer) id, CourseSessionEntity.class.getCanonicalName());
    }


    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(CourseSessionEntity.class.getCanonicalName());
    }

    public List<IEntity> getEntitiesByTimeStamp(final Timestamp tmin, final Timestamp tmax) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> listEntities = null;

        try {
            Query query = session.createQuery("from " + CourseSessionEntity.class.getCanonicalName() + " c where c.startDate < :timeStampMax and c.startDate > :timeStampMin");
            query.setParameter("timeStampMin", tmin);
            query.setParameter("timeStampMax", tmax);
            listEntities = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }
        return listEntities;
    }



    public List<IEntity> getEntitiesByLocationId(final int location_id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> course_session_list = null;
        try {
            Query query = session.createQuery("from CourseSessionEntity where location.idLocation = :location_id");
            query.setParameter("location_id", location_id);
            course_session_list = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntitiesByLocationId" + e);
        }
        return course_session_list;
    }


    public List<IEntity> getEntitiesByTitle(final String filter) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> course_list = null;
        try {
            Query query = session.createQuery("from CourseEntity where title like :titleFilter");
            query.setParameter("titleFilter", "%" + filter + "%");
            course_list = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }

        List<IEntity> course_session_list = null;

        if (course_list != null) {
            for (IEntity entity : course_list) {
                CourseEntity course = (CourseEntity) entity;
                try {
                    Query query = session.createQuery("from CourseSessionEntity where course.codeCourse like :code");
                    query.setParameter("code", course.getCodeCourse());
                    course_session_list = query.list();
                } catch (HibernateException e) {
                    System.out.println("getEntities" + e);
                }
            }
        }
        return course_session_list;
    }
}