package core.DAO;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */
import core.Entity.ClientEntity;
import core.Entity.IEntity;

import java.util.List;


public class ClientDao implements IDao{


    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }


    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((Integer) id, ClientEntity.class.getCanonicalName(), entity);
    }


    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((Integer) id, ClientEntity.class.getCanonicalName());
    }


    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((Integer) id, ClientEntity.class.getCanonicalName());
    }


    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(ClientEntity.class.getCanonicalName());
    }
}