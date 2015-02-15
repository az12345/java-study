package nedis.demo.webtasks.dao.impl;

import nedis.demo.webtasks.dao.AccountDao;
import nedis.demo.webtasks.db.ConnectionFactory;
import nedis.demo.webtasks.model.Account;

/**
 * @author nedis
 * @version 1.0
 */
public class AccountDaoImpl extends AbstractEntityDao<Account> implements AccountDao {
	public AccountDaoImpl(ConnectionFactory connectionFactory) {
		super(connectionFactory);
	}

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

}
