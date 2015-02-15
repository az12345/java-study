package nedis.demo.webtasks.dao;

import java.util.List;

import nedis.demo.webtasks.model.IEntity;
import nedis.demo.webtasks.services.IClosable;

/**
 * @author nedis
 * @version 1.0
 */
public interface IEntityDao<T extends IEntity> extends IClosable {

	void create(T object);
	
	void update(T object);
	
	void delete(T object);
	
	T findById(Object id);
	
	T findByField(String name, Object id);
	
	List<T> findAll();
}
