package nedis.demo.webtasks.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import nedis.demo.webtasks.db.ConnectionFactory;

/**
 * @author nedis
 * @version 1.0
 */
public class MysqlDriverManagerConnectionFactory implements ConnectionFactory {

	private static final String URL = "jdbc://mysql/localhost:3306/test";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
