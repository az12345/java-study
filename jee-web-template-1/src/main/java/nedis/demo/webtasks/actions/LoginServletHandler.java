package nedis.demo.webtasks.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nedis.demo.webtasks.WebtasksConstants;
import nedis.demo.webtasks.exceptions.InvalidDataException;
import nedis.demo.webtasks.model.Account;
import nedis.demo.webtasks.model.Role;

import org.apache.commons.lang.StringUtils;

/**
 * @author nedis
 * @version 1.0
 */
public class LoginServletHandler extends AbstractWebtasksServletHandler {
	private static final long serialVersionUID = 4544737546336836686L;

	private final Map<Integer, String> homePages = new HashMap<Integer, String>();
	
	public LoginServletHandler() {
		homePages.put(ROLE_ADMIN, 		"/admin/home.php");
		homePages.put(ROLE_USER, 		"/user/home.php");
	}
	
	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("GET")) {
			showLoginPage(request, response);
		}
		else{
			loginHandler(request, response);
		}
	}

	protected void showLoginPage (HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<Role> roles = getDataService().listRoles();
		request.setAttribute("roles", roles);
		gotoToJSP("/login.jsp", request, response);
	}
	
	protected void validateRequest (String username, String password) throws InvalidDataException {
		if(StringUtils.isBlank(username)) {
			throw new InvalidDataException("Username is blank");
		}
		if(StringUtils.isBlank(password)) {
			throw new InvalidDataException("Password is blank");
		}
	}
	
	protected void loginHandler (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer idRole  = Integer.parseInt(request.getParameter("role"));
		try {
			validateRequest(username, password);
			Account a = getDataService().login(username, password, idRole);
			String homePage = homePages.get(idRole);
			if(homePage != null) {
				request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, a);
				redirectRequest(homePage, request, response);
			}
			else{
				throw new InvalidDataException("Unsupported role id "+idRole);
			}
		} catch (InvalidDataException e) {
			request.setAttribute(WebtasksConstants.VALIDATION_MESSAGE, e.getMessage());
			gotoToJSP("login.jsp", request, response);
		}
	}
}
