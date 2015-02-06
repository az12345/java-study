package nedis.demo.webtasks.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author nedis
 * @version 1.0
 */
public class TestDemoFilter extends AbstractWebtasksFilter {
	private String developer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		developer = filterConfig.getServletContext().getInitParameter("developer");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(StringUtils.isNotBlank(developer)) {
			response.addHeader("Developer", developer);
			response.addCookie(new Cookie("Developer", developer));
			response.addCookie(new Cookie("JavaVersion", System.getProperty("java.version")));
			response.addCookie(new Cookie("OS", System.getProperty("os.name")));
			response.addCookie(new Cookie("JavaHome", System.getProperty("java.home")));
		}
		chain.doFilter(request, response);
	}
}
