package nedis.demo.webtasks.db;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nedis.demo.webtasks.annotations.Column;
import nedis.demo.webtasks.annotations.Id;
import nedis.demo.webtasks.annotations.Table;
import nedis.demo.webtasks.exceptions.WebtasksDataException;
import nedis.demo.webtasks.model.IEntity;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author nedis
 * @version 1.0
 */
public class DBUtils {
	private static final Logger LOGGER = Logger.getLogger(DBUtils.class);
	
	protected static void closeConnection(Connection c){
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				LOGGER.warn("Connection close failed: "+e.getMessage());
			}
		}
	}
	
	public static int executeUpdate (ConnectionFactory connectionFactory, String sqlQuery, Object[] args) throws WebtasksDataException {
		Connection c = null;
		try {
			c = connectionFactory.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			if(args != null){
				for(int i=0;i<args.length;i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new WebtasksDataException(e);
		} finally {
			closeConnection(c);
		}
	}
	
	public static List<? extends IEntity> listEntities(ConnectionFactory connectionFactory, String sqlQuery, Object[] args, 
			Class<? extends IEntity> clazz) throws WebtasksDataException {
		Connection c = null;
		try {
			c = connectionFactory.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			if(args != null){
				for(int i=0;i<args.length;i++) {
					ps.setObject(i+1, args[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			List<IEntity> res = new ArrayList<IEntity>();
			//makes all not static fields as accesible
			Field[] fileds = clazz.getDeclaredFields();
			for(Field f : fileds) {
				if(!Modifier.isStatic(f.getModifiers())) {
					f.setAccessible(true);
				}
			}
			while(rs.next()) {
				IEntity entity = clazz.newInstance();
				for(Field f : fileds) {
					if(!Modifier.isStatic(f.getModifiers())) {
						String dbColumnName = getColumnName(f);
						if(dbColumnName != null) {
							Object value = rs.getObject(dbColumnName);
							f.set(entity, value);
						}
					}
				}
				res.add(entity);
			}
			return res;
		} catch (Exception e) {
			throw new WebtasksDataException(e);
		} finally {
			closeConnection(c);
		}
	}
	
	public static String getColumnName(Class<? extends IEntity> clazz, String f) {
		try {
			return getColumnName(clazz.getDeclaredField(f));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static String getColumnName(Field f) {
		Column column = f.getAnnotation(Column.class);
		String dbColumnName = null;
		if(column != null) {
			dbColumnName = column.value();
			if(StringUtils.isBlank(dbColumnName)) {
				dbColumnName = f.getName();
			}
			return dbColumnName;
		}
		else{
			return null;
		}
	}
	
	public static Object getIdValue (IEntity entity) {
		Field[] fileds = entity.getClass().getDeclaredFields();
		for(Field f : fileds) {
			Id id = f.getAnnotation(Id.class);
			if(id != null) {
				try {
					return f.get(entity);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		throw new IllegalArgumentException("Entity class "+entity.getClass().getName()+" does not have any fields with Id annotation");
	}
	
	public static String getIdColumn(Class<? extends IEntity> clazz) {
		Field[] fileds = clazz.getDeclaredFields();
		for(Field f : fileds) {
			Id id = f.getAnnotation(Id.class);
			if(id != null) {
				return getColumnName(f);
			}
		}
		throw new IllegalArgumentException("Entity class "+clazz.getName()+" does not have any fields with Id annotation");
	}
	
	public static String getTableName(Class<? extends IEntity> clazz) {
		Table table = clazz.getAnnotation(Table.class);
		if(table != null) {
			String tableName = table.value();
			if(StringUtils.isNotBlank(tableName)) {
				return tableName;
			}
			else{
				return clazz.getSimpleName();
			}
		}
		else{
			throw new IllegalArgumentException("Entity class "+clazz.getName()+" does not have Table annotation");
		}
	}
}
