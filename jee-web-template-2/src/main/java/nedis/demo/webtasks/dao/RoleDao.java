package nedis.demo.webtasks.dao;

import java.util.List;

import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;

/**
 * @author nedis
 * @version 1.0
 */
public interface RoleDao extends IEntityDao<Role> {

	List<Role> findAccountRoles(Account account);
}
