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

    public List getEntitiesTest() {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List <String[]> listEntities = null;
        try {
            Query query =
                    session.createQuery("select c.codeCourse, c.startDate, c.endDate, l.city " +
                            "from CourseSessionEntity c inner join LocationEntity l");
            listEntities = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntities: " + e);
        }
        return listEntities;
    }


    public List<IEntity> getEntitiesByLocationId(final int location_id) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> course_session_list = null;
        try {
            Query query = session.createQuery("from CourseSessionEntity where idLocation = :location_id");
            query.setParameter("location_id", location_id);
            course_session_list = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntitiesByLocationId" + e);
        }
        return course_session_list;
    }

    public List<IEntity> getEntitiesByFilters(final int location_id, final Timestamp date, final String title) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> course_session_list = null;
        List<IEntity> course_list = null;
        try {
            Query query = session.createQuery("from CourseEntity where title like :titleFilter");
            query.setParameter("titleFilter", "%" + title + "%");
            course_list = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }

        if (course_list != null) {
            for (IEntity entity : course_list) {
                CourseEntity course = (CourseEntity) entity;
                try {
                    Query query = session.createQuery("from CourseSessionEntity where codeCourse like :code and idLocation = :location_id");
                    query.setParameter("code", "%" + course.getCodeCourse() + "%");
                    query.setParameter("location_id", location_id);
                    course_session_list = query.list();
                } catch (HibernateException e) {
                    System.out.println("getEntities" + e);
                }
            }
        }

       /* try {
            Query query = session.createQuery("from CourseSessionEntity where idLocation = :location_id and codeCourse like :title");
            query.setParameter("location_id",  location_id);
            query.setParameter("title",  title);
            course_session_list = query.list();
        }catch (HibernateException e) {
            System.out.println("getEntitiesByLocationId" + e);
        }*/

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
                    Query query = session.createQuery("from CourseSessionEntity where codeCourse like :code");
                    query.setParameter("code", course.getCodeCourse());
                    course_session_list = query.list();
                } catch (HibernateException e) {
                    System.out.println("getEntities" + e);
                }
            }
        }
        return course_session_list;
    }
 /*public List<IEntity> getEntitiesByLocation(final String filter) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> listEntities = null;

        try {
            Query query = session.createQuery("from " + LocationEntity.class.getCanonicalName() + " where city = :cityFilter");
            query.setParameter("cityFilter", filter);
            listEntities = query.list();
        }catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }

        List<IEntity> listResult;
        listResult = new ArrayList<IEntity>();

        for(IEntity entity : listEntities) {
            LocationEntity location = (LocationEntity) entity;

            List<IEntity> listEntities2 = null;

            try {
                Query query = session.createQuery("from " + CourseSessionEntity.class.getCanonicalName() + " where Id_Location = :locationFilter");
                query.setParameter("locationFilter", location);
                listEntities2 = query.list();
                listResult.addAll(listEntities2);
            }catch (HibernateException e) {
                System.out.println("getEntities" + e);
            }
        }
        return listResult;
    }*/
}