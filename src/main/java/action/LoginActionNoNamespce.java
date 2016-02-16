package action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

@ParentPackage("json-default")
public class LoginActionNoNamespce extends SuperActionSupport {
	private static final long serialVersionUID = 1L;

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

	private Map<String, String> dataMap;

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	@SkipValidation
	@Action(value = "ajaxExecute", results = { @Result(type = "json", params = { "root", "dataMap" }) })
	public String ajaxExecute() throws Exception {
		this.dataMap = new HashMap<String, String>();

		// 参数名称必须和jsp的空间名称一一对应
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		dataMap.put("userName", "Hi:" + userName);
		dataMap.put("password", password);

		return SUCCESS;

		/*
		 * JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
		 * String result = json.toString();// 给result赋值，传递给页面
		 * System.err.println("result:" + result); return result;
		 */
	}

}
