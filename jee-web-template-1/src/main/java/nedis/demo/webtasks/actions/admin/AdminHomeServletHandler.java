package nedis.demo.webtasks.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nedis.demo.webtasks.actions.AbstractWebtasksServletHandler;

/**
 * @author nedis
 * @version 1.0
 */
public class AdminHomeServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 2821398058404801717L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		gotoToJSP("admin/home.jsp", request, response);
	}
}
