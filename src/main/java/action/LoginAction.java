package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import net.sf.json.JSONObject;

@ParentPackage("struts-default")
@Namespace("/login")
@Results({ @Result(name = "success", location = "/WEB-INF/content/LoginInfo/add.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class LoginAction extends SuperActionSupport {

	private String userName;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// 登录页
	@SkipValidation
	@Action(value = "login", results = { @Result(location = "/WEB-INF/content/LoginInfo/login.jsp") })
	public String login() throws Exception {
		return SUCCESS;
	}

	@Action(value = "loginValidate", results = {
			@Result(name = "success", location = "/WEB-INF/content/LoginInfo/success.jsp"),
			@Result(name = "input", location = "/WEB-INF/content/LoginInfo/login.jsp") })
	public String loginValidate() throws Exception {
		/*
		 * if (this.getFieldErrors().size() > 0) { return INPUT; }
		 */
		this.session.setAttribute("userName", this.getUserName());
		this.request.setAttribute("name", "张山峰");
		return SUCCESS;
	}

	@Override
	public void validate() {
		// this.getUserName().trim().equals("")和this.getUserName().trim()==""效果不一样
		if (this.getUserName() == null || this.getUserName().trim().equals("")) {
			this.addFieldError("userName", "用户名不能为空");
		}
	}

	// 验证失败
	@SkipValidation
	@Action(value = "loginError", results = {
			@Result(name = "error", location = "/WEB-INF/content/LoginInfo/error.jsp") })
	public String loginError() throws Exception {
		return ERROR;
	}

	@SkipValidation
	@Action(value = "ajaxExecute")
	public String ajaxExecute() throws Exception {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", age);

		JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
		String result = json.toString();// 给result赋值，传递给页面

		System.err.println("Ajax Name:" + request.getParameter("name"));
		return SUCCESS;
	}

	/*
	 * // 登录提交 // 完整路径为：http://localhost:8080/login/loginIndex //
	 * 注意大小写，使用loginIndex就可以找到，LoginIndex就找不到
	 * 
	 * @SkipValidation
	 * 
	 * @Action(value = "userIndex", results = {
	 * 
	 * @Result(name = "success", location =
	 * "/WEB-INF/content/LoginInfo/success.jsp") }) public String userIndex()
	 * throws Exception { return SUCCESS; }
	 */
}
