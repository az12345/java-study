package nedis.demo.webtasks.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nedis
 * @version 1.0
 */
public class ErrorServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 4544737546336836686L;
	
	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		gotoToJSP("/error.jsp", request, response);
	}
}
