package web.controllers.UserCenter;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.common.Constants;
import biz.common.annotations.Authority;
import dal.beans.UserInfo;
import dal.dataaccess.UserInfoDal;
import web.base.*;

@SuppressWarnings("serial")
@ParentPackage("custom-default")
@Namespace("/userinfo")
public class UserInfoController extends SuperActionSupport {

	// [start]字段和属性
	private String loginResult;

	public String getLoginResult() {
		return loginResult;
	}

	private String registerResult;

	public String getRegisterResult() {
		return registerResult;
	}

	private List<UserInfo> listUserInfo;

	public List<UserInfo> getListUserInfo() {
		return listUserInfo;
	}

	// [end]

	// location = "/WEB-INF/content/UserInfo/Register.jsp"
	// struts.convention.result.path =/WEB-INF/content/
	// 完整路径为：/WEB-INF/content/命名空间/location
	// @SkipValidation
	@Action(value = "login", results = { @Result(location = "Login.jsp") })
	public String login() throws Exception {
		return SUCCESS;
	}

	@Action(value = "userlogin", results = { @Result(type = "json", params = { "root", "loginResult" }) })
	// @Authority("")
	public String UserLogin() throws Exception {
		// 参数名称必须和jsp的空间名称一一对应
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		loginResult = "";
		if (!userName.equals("James")) {
			loginResult = "用户名不正确";
		}

		this.session.setAttribute(Constants.UserName, userName);
		return SUCCESS;
	}

	@Authority("")
	@Action(value = "userindex", results = { @Result(name = "success", location = "UserIndex.jsp") })
	public String loginIndex() throws Exception {
		UserInfoDal dal = new UserInfoDal();
		this.listUserInfo = dal.GetAll();

		//System.err.println("Size:" + this.listUserInfo.size());
		return SUCCESS;
	}

	@Action(value = "loginout", results = { @Result(name = "loginout", location = "Login.jsp") })
	public String loginout() throws Exception {

		// this.session.removeAttribute(Constants.UserName);
		this.session.invalidate();
		return "loginout";
	}

	@Action(value = "register", results = { @Result(location = "Register.jsp") })
	public String register() throws Exception {
		return SUCCESS;
	}

	@Action(value = "userregister", results = { @Result(type = "json", params = { "root", "registerResult" }) })
	// @Authority("")
	public String UserRegister() throws Exception {

		// 参数名称必须和jsp的空间名称一一对应
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		registerResult = "";
		if (userName.equals("")) {
			registerResult = "用户名不能为空";
		}
		if (password.equals("")) {
			registerResult = "密码不能为空";
		}

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setPassword(password);

		UserInfoDal dal = new UserInfoDal();
		if (dal.Insert(userInfo) > 0) {
			this.session.setAttribute(Constants.UserName, userName);
		} else {
			registerResult = "注册失败";
		}
		return SUCCESS;
	}
}
