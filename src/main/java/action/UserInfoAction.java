package action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.UserInfo;

public class UserInfoAction extends ActionSupport
implements ModelDriven<UserInfo>
{
	private UserInfo ui=new UserInfo();
	public String UserList() throws Exception {
		return SUCCESS;
	}
	
	public String UserLogin() throws Exception {
		String userName=this.ui.getUserName();
		System.err.println(userName);
		if(userName==null||userName=="")
		{
		  this.addFieldError("username", "用户名不能为空");
		  return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String UserIndex() throws Exception {
		//System.err.println(this.ui.getUserName());
		//System.err.println(this.ui.getPassword());
		//System.err.println(this.ui.getUserInfoList().get(0).getUserName());
		//System.err.println(this.ui.getUserInfoList().get(1).getUserName());		
		return SUCCESS;
	}

	//传递参数，通常是ajax传递
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return ui;
	}
}
