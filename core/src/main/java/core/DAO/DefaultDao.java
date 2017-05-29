package core.DAO;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */

import java.util.List;

import core.Entity.IEntity;
import core.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class DefaultDao {


    /**
     * To insert an entity into the database
     *
     * @param entity
     */
    public static void insertEntity(final IEntity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("insertEntity: " + e);
        }
    }

    /**
     * To update an entity into the database
     *
     * @param id
     * @param clazz
     * @param entity
     */
    public static void updateEntity(final int id, final String clazz, final IEntity entity) {

    }

    /**
     * To update an entity into the database
     *
     * @param id
     * @param clazz
     * @param entity
     */
    public static void updateEntity(final String id, final String clazz, final IEntity entity) {

    }

    /**
     * To remove an entity into the database
     *
     * @param id
     * @param clazz
     */
    public static void removeEntity(final int id, final String clazz) {
        IEntity entity = DefaultDao.getEntity(id, clazz);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("removeEntity: " + e);
        }
    }

    /**
     * To remove an entity into the database
     *
     * @param id
     * @param clazz
     */
    public static void removeEntity(final String id, final String clazz) {
        IEntity entity = DefaultDao.getEntity(id, clazz);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("removeEntity: " + e);
        }
    }

    /**
     * To get an entity from his id and class
     *
     * @param id
     * @param clazz
     * @return
     */
    public static IEntity getEntity(final int id, final String clazz) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("getEntity: " + e);
        }
        return entity;
    }

    /**
     * To get an entity from his id and class
     *
     * @param id
     * @param clazz
     * @return
     */
    public static IEntity getEntity(final String id, final String clazz) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("getEntity: " + e);
        }
        return entity;
    }

    /**
     * To get all the entities
     *
     * @param clazz
     * @return
     */
    public static List<IEntity> getEntities(final String clazz) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + clazz);
            listEntities = query.list();
        } catch (HibernateException e) {
            System.out.println("getEntities: " + e);
        }
        return listEntities;
    }

}
