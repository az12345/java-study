package nedis.demo.webtasks.services;

import javax.servlet.ServletContext;

import nedis.demo.webtasks.dao.AccountDao;
import nedis.demo.webtasks.dao.RoleDao;
import nedis.demo.webtasks.dao.impl.AccountDaoImpl;
import nedis.demo.webtasks.dao.impl.RoleDaoImpl;
import nedis.demo.webtasks.db.ConnectionFactory;
import nedis.demo.webtasks.db.mysql.MysqlDriverManagerConnectionFactory;
import nedis.demo.webtasks.services.mocks.DataServiceImpl;

import org.apache.log4j.Logger;

/**
 * @author nedis
 * @version 1.0
 */
public final class WebtasksServiceManager {
	private static final Logger LOGGER = Logger.getLogger(WebtasksServiceManager.class);
	private static final String WEBTASKS_SERVICES_MANAGER = "WEBTASKS_SERVICES_MANAGER";
	private static final WebtasksServiceManager INSTANCE = new WebtasksServiceManager();
	private WebtasksServiceManager () {
		
	}
	public static WebtasksServiceManager getInstance (ServletContext context) {
		WebtasksServiceManager instance = (WebtasksServiceManager) context.getAttribute(WEBTASKS_SERVICES_MANAGER);
		if(instance == null) {
			context.setAttribute(WEBTASKS_SERVICES_MANAGER, INSTANCE);
			instance = INSTANCE;
		}
		return instance;
	}
	
	private ConnectionFactory connectionFactory;
	private AccountDao accountDao;
	private RoleDao roleDao;
	private DataService dataService;
	public DataService getDataService() {
		return dataService;
	}
	
	private void initAllDependencies() {
		connectionFactory = new MysqlDriverManagerConnectionFactory();
		accountDao = new AccountDaoImpl(connectionFactory);
		roleDao = new RoleDaoImpl(connectionFactory);
		dataService = new DataServiceImpl(accountDao, roleDao);
	}
	
	public void startAllServices(){
		initAllDependencies();
		LOGGER.info("All services have been started");
	}
	
	public void closeAllServices (){
		dataService.close();
		LOGGER.info("All services have been closed");
	}
}
