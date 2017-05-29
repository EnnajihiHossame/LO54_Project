package core.DAO;

import core.Entity.CourseEntity;
import core.Entity.IEntity;

import java.util.List;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */
public class CourseDao implements IDao{



    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((String) id, CourseEntity.class.getCanonicalName(), entity);
    }

    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(CourseEntity.class.getCanonicalName());
    }

    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((String) id, CourseEntity.class.getCanonicalName());
    }

    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((String) id, CourseEntity.class.getCanonicalName());
    }

    public void InsertEntity(IEntity entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}