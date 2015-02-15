package nedis.demo.webtasks.dao.impl;

import java.util.Collections;
import java.util.List;

import nedis.demo.webtasks.dao.RoleDao;
import nedis.demo.webtasks.db.ConnectionFactory;
import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;

/**
 * @author nedis
 * @version 1.0
 */
public class RoleDaoImpl extends AbstractEntityDao<Role> implements RoleDao {

	public RoleDaoImpl(ConnectionFactory connectionFactory) {
		super(connectionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAccountRoles(Account account) {
		// TODO Should be implemneted
		return Collections.EMPTY_LIST;
	}

	@Override
	protected Class<Role> getEntityClass() {
		return Role.class;
	}

}
