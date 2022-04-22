package in.developershut.bs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionChecker implements Interceptor {

	private static final long serialVersionUID = 1L;
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("Inside interceptor");
		Map<String, Object> sessionMap = actionInvocation.getInvocationContext().getSession();
		System.out.println(sessionMap.get("loginFlag"));
		System.out.println(sessionMap.get("userName"));
		System.out.println(sessionMap.get("currentLoginTime"));
		boolean isUserLoggedIn = sessionMap.get("loginFlag") != null && sessionMap.get("userName") != null && sessionMap.get("currentLoginTime") != null;
		if(isUserLoggedIn) {
			System.out.println("Session alive");
			return actionInvocation.invoke();
		} else {
			System.out.println("Session dead");
			return Action.LOGIN;
		}
	}
}
