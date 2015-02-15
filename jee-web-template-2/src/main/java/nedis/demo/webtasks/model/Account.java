package nedis.demo.webtasks.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import nedis.demo.webtasks.annotations.Column;
import nedis.demo.webtasks.annotations.Id;
import nedis.demo.webtasks.annotations.Table;

import org.apache.log4j.Logger;

/**
 * @author nedis
 * @version 1.0
 */
@Table("account")
public class Account extends AbstractModelBean implements HttpSessionBindingListener {
	private static final Logger LOGGER = Logger.getLogger(Account.class);
	private static final long serialVersionUID = -5787220666753301113L;
	
	@Id
	@Column
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	public Account() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	protected Object getIdModel() {
		return getUsername();
	}
	@Override
	public void valueBound(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("Account has been added to session with id='");
			message.append(se.getSession().getId());
			message.append("' and been bound to name='");
			message.append(se.getName());
			message.append("'");
			LOGGER.debug(message);
		}
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("Account has been removed from session with id='");
			message.append(se.getSession().getId());
			message.append("'");
			LOGGER.debug(message);
		}
	}
}
