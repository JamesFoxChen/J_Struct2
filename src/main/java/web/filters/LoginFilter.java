package web.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {

		System.err.println("Login Filter"+new Date().toString());
		
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		String url = request.getServletPath();
		//url：/login/loginIndex
		String contextPath = request.getContextPath();
		if (url.equals(""))
			url += "/";
		
		System.err.println("url:"+url);
		//非登录验证页面不用过滤，使用拦截器实现此功能
	/*	if (url.startsWith("/") 
				&&!url.contains("/login/login")
				&&!url.contains("/login/loginValidate")
				&&!url.contains("/ajaxExecute")) {
																	
			String user = (String) session.getAttribute("userName");
			if (user == null) {
				System.err.println("登录验证:未登录");
				response.sendRedirect("/login/loginError");
				return;
			}
		}*/
		chain.doFilter(sRequest, sResponse);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
