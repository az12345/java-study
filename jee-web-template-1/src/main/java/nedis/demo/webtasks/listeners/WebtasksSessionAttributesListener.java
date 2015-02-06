package nedis.demo.webtasks.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

/**
 * @author nedis
 * @version 1.0
 */
public class WebtasksSessionAttributesListener implements HttpSessionAttributeListener {
	private static final Logger LOGGER = Logger.getLogger(WebtasksSessionAttributesListener.class);
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("A new attribute with name='");
			message.append(se.getName());
			message.append("' and value='");
			message.append(se.getValue());
			message.append("' has been added to session with id='");
			message.append(se.getSession().getId());
			message.append("'");
			LOGGER.debug(message);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("An attribute with name='");
			message.append(se.getName());
			message.append("' and value='");
			message.append(se.getValue());
			message.append("' has been removed from session with id='");
			message.append(se.getSession().getId());
			message.append("'");
			LOGGER.debug(message);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if(LOGGER.isDebugEnabled()) {
			StringBuilder message = new StringBuilder("An attribute with name='");
			message.append(se.getName());
			message.append("' and value='");
			message.append(se.getValue());
			message.append("' has been replaced for session with id='");
			message.append(se.getSession().getId());
			message.append("'");
			LOGGER.debug(message);
		}
	}

}
