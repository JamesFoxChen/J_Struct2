package main.java;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
    private static final long serialVersionUID = 6872366878758961847L;
    //重写execute()方法
    public String execute() throws Exception {
//        System.out.println("欢迎使用struts2!");
//        return super.execute();
    	
    	return SUCCESS;
    }
}