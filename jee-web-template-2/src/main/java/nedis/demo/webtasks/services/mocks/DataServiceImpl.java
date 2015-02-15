package nedis.demo.webtasks.services.mocks;

import java.util.List;

import nedis.demo.webtasks.dao.AccountDao;
import nedis.demo.webtasks.dao.RoleDao;
import nedis.demo.webtasks.exceptions.InvalidDataException;
import nedis.demo.webtasks.exceptions.WebtasksDataException;
import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;
import nedis.demo.webtasks.services.DataService;

import org.apache.commons.lang.StringUtils;

/**
 * @author nedis
 * @version 1.0
 */
public class DataServiceImpl implements DataService {
	
	private AccountDao accountDao;
	
	private RoleDao roleDao;
	
	public DataServiceImpl(AccountDao accountDao, RoleDao roleDao) {
		super();
		this.accountDao = accountDao;
		this.roleDao = roleDao;
	}

	@Override
	public Account login(String username, String password, Integer role) throws InvalidDataException {
		Account a = accountDao.findByField("username", username);
		if(a == null) {
			throw new InvalidDataException("Account not found");
		}
		else{
			if(StringUtils.equals(password, a.getPassword())) {
				List<Role> roles = roleDao.findAccountRoles(a); 
				for(Role r : roles) {
					if(r.getId().equals(role)) {
						return a;
					}
				}
				throw new InvalidDataException("Invalid role");
			}
			else{
				throw new InvalidDataException("Invalid password");
			}
		}
	}
	
	@Override
	public List<Role> listRoles() throws WebtasksDataException {
		return roleDao.findAll();
	}
	
	@Override
	public void close() {
		accountDao.close();
		roleDao.close();
	}
}
