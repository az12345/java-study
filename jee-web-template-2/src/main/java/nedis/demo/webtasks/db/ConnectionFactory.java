package nedis.demo.webtasks.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author nedis
 * @version 1.0
 */
public interface ConnectionFactory {

	Connection getConnection() throws SQLException ;
}
