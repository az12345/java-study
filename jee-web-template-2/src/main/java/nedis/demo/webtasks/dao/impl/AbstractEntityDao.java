package nedis.demo.webtasks.dao.impl;

import java.util.List;

import nedis.demo.webtasks.dao.IEntityDao;
import nedis.demo.webtasks.db.ConnectionFactory;
import nedis.demo.webtasks.db.DBUtils;
import nedis.demo.webtasks.model.IEntity;

/**
 * @author nedis
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntityDao<T extends IEntity> implements IEntityDao<T> {
	protected abstract Class<T> getEntityClass();
	
	private ConnectionFactory connectionFactory;
	public AbstractEntityDao(ConnectionFactory connectionFactory) {
		super();
		this.connectionFactory = connectionFactory;
	}

	@Override
	public void create(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(T object) {
		String dbColumn = DBUtils.getIdColumn(getEntityClass());
		String tableName = DBUtils.getTableName(getEntityClass());
		DBUtils.executeUpdate(connectionFactory, "delete from "+tableName+" where "+dbColumn+"=?", new Object[]{DBUtils.getIdValue(object)});
	}

	@Override
	public T findById(Object id) {
		String dbColumn = DBUtils.getIdColumn(getEntityClass());
		String tableName = DBUtils.getTableName(getEntityClass());
		List<T> list = (List<T>) DBUtils.listEntities(connectionFactory, "select * from "+tableName+" where "+dbColumn+"=?", new Object[]{id}, getEntityClass());
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public T findByField(String name, Object value) {
		String dbColumn = DBUtils.getColumnName(getEntityClass(), name);
		String tableName = DBUtils.getTableName(getEntityClass());
		List<T> list = (List<T>) DBUtils.listEntities(connectionFactory, "select * from "+tableName+" where "+dbColumn+"=?", new Object[]{value}, getEntityClass());
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public List<T> findAll() {
		String tableName = DBUtils.getTableName(getEntityClass());
		return (List<T>) DBUtils.listEntities(connectionFactory, "select * from "+tableName, null, getEntityClass());
	}
	
	@Override
	public void close() {
		//do noting
	}
}
