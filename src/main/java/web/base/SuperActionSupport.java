package web.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SuperActionSupport extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	protected ServletContext context = null;
    protected HttpSession session=null;
    
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session=request.getSession();
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
