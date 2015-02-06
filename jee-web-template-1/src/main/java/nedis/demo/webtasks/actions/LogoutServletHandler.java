package nedis.demo.webtasks.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nedis
 * @version 1.0
 */
public class LogoutServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = -120978214941991129L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		redirectRequest("/login.php", request, response);
	}

}
