package nedis.demo.webtasks.services;

import java.util.List;

import nedis.demo.webtasks.exceptions.InvalidDataException;
import nedis.demo.webtasks.exceptions.WebtasksDataException;
import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;

/**
 * @author nedis
 * @version 1.0
 */
public interface DataService extends IClosable {
	
	Account login (String username, String password, Integer role) throws InvalidDataException, WebtasksDataException;
	
	List<Role> listRoles() throws WebtasksDataException;
}
