package nedis.demo.webtasks.services.mocks;

import java.util.List;

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

	@Override
	public Account login(String username, String password, Integer role) throws InvalidDataException {
		for(Account a : DataStorage.ALL_ACCOUNTS) {
			if(StringUtils.equals(username, a.getUsername())) {
				if(StringUtils.equals(password, a.getPassword())) {
					for(Role r : a.getRoles()) {
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
		throw new InvalidDataException("Account not found");
	}
	
	@Override
	public List<Role> listRoles() throws WebtasksDataException {
		return DataStorage.ALL_ROLES;
	}
	
	@Override
	public void close() {
		
	}
}
