package core.DAO;

/**
 * Created by ennajihihoussame on 29/05/2017.
 */
import core.Entity.IEntity;
import java.util.List;

public interface IDao<T> {

    /**
     * To insert an entity into the database
     * @param entity
     */
    void insertEntity(final IEntity entity);

    /**
     * To update an entity into the database
     * @param id
     * @param entity
     */
    void updateEntity(final T id, final IEntity entity);

    /**
     * To remove an entity into the database
     * @param id
     */
    void removeEntity(final T id);

    /**
     * To get an entity from an id
     * @param id
     * @return
     */
    IEntity getEntity(final T id);


    /**
     * To get all the entities
     * @return
     */
    List<IEntity> getEntities();

}