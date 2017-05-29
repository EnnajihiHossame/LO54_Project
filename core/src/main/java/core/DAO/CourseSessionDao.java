package core.DAO;

import core.Entity.CourseEntity;
import core.Entity.CourseSessionEntity;
import core.Entity.IEntity;
import core.Entity.LocationEntity;
import core.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        }catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }
        return listEntities;
    }

    public List<IEntity> getEntitiesByLocation(final String filter) {
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
    }

    public List<IEntity> getEntitiesByTitle(final String filter) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + CourseEntity.class.getCanonicalName() + " where title like :titleFilter");
            query.setParameter("titleFilter", "%" + filter + "%");
            listEntities = query.list();
        }catch (HibernateException e) {
            System.out.println("getEntities" + e);
        }

        List<IEntity> listEntities2 = null;

        if (listEntities != null) {
            for(IEntity entity : listEntities) {
                CourseEntity course = (CourseEntity) entity;
                try {
                    Query query = session.createQuery("from " + CourseSessionEntity.class.getCanonicalName() + " where course like :code");
                    query.setParameter("code", course);
                    listEntities2 = query.list();
                }catch (HibernateException e) {
                    System.out.println("getEntities" + e);
                }
            }
        }
        return listEntities2;
    }
}