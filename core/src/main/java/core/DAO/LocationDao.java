package core.DAO;

import core.Entity.IEntity;
import core.Entity.LocationEntity;

import java.util.List;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */
public class LocationDao implements IDao {

    public void insertEntity(IEntity entity) {
        DefaultDao.insertEntity(entity);

    }

    public void updateEntity(Object id, IEntity entity) {
        DefaultDao.updateEntity((Integer) id, LocationDao.class.getCanonicalName(), entity);

    }

    public void removeEntity(Object id) {
        DefaultDao.removeEntity((Integer) id, LocationDao.class.getCanonicalName());

    }

    public IEntity getEntity(Object id) {
        return DefaultDao.getEntity((Integer) id, LocationEntity.class.getCanonicalName());
    }

    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(LocationEntity.class.getCanonicalName());
    }

}
