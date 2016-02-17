package interceptors;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import annotations.Authority;
import common.Constants;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String methodName = invocation.getProxy().getMethod();
		Class clazz = invocation.getAction().getClass(); // 获取类对象
		Method currentMethod = clazz.getMethod(methodName); //获取拦截的方法
		
		//方法上添加了注解
		if (currentMethod.isAnnotationPresent(Authority.class)) {
			// 取得当前请求的注解的action
			ActionContext context = invocation.getInvocationContext();
			Map session = context.getSession();
			//Constants.UserName=="UserName"
			String user = (String) session.get(Constants.UserName);

			System.err.println("拦截器起作用");
			if (user == null) // 未登陆，跳转到登录页
			{
				System.err.println("进入拦截器：未登陆");
				context.put("tip", "你还没有登录");
				return Action.LOGIN;
			} else {   //已登录，继续后续流程
				System.err.println("进入拦截器：已登录");
				return invocation.invoke();
			}
		} else {
			System.err.println("进入拦截器：没有使用注解");
			return invocation.invoke();
		}
	}
}

/*	boolean b = clazz.isAnnotationPresent(InterceptorRef.class);
if(b)
{
	System.err.println("类拦截器：InterceptorRef");
	return invocation.invoke();
}*/

