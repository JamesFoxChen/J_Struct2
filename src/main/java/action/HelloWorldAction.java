package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
    private static final long serialVersionUID = 6872366878758961847L;
    //重写execute()方法
    public String execute() throws Exception {
    	ActionContext ctx = ActionContext.getContext();
    	ctx.getApplication().put("counter" , 1);
    	
    	return SUCCESS;
    }
    
    public String add() throws Exception {
    	return SUCCESS;
    }
    
    public String update() throws Exception {
    	return SUCCESS;
    }
}