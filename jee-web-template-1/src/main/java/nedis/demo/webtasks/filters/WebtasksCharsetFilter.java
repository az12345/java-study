package nedis.demo.webtasks.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author nedis
 * @version 1.0
 */
public class WebtasksCharsetFilter extends AbstractWebtasksFilter{
	private String encoding = "UTF-8";
	
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		String encoding = filterconfig.getInitParameter("encoding");
		if(StringUtils.isNotBlank(encoding)) {
			this.encoding = encoding;
		}
	}

	@Override
	public void doFilter(HttpServletRequest httprequest, HttpServletResponse httpResponse, FilterChain chain) throws IOException, ServletException {
		httprequest.setCharacterEncoding(encoding);
		httpResponse.setCharacterEncoding(encoding);
		chain.doFilter(httprequest, httpResponse);
	}
}
