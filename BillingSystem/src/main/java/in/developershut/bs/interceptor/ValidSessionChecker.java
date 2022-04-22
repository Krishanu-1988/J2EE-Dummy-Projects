package in.developershut.bs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidSessionChecker implements Interceptor {

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
		System.out.println("Inside Valid SessionChecker interceptor: " + getClass().getName());
		Map<String, Object> sessionMap = actionInvocation.getInvocationContext().getSession();
		ActionSupport actionSupport = new ActionSupport();
		
		Object sessionFlag = sessionMap.get(actionSupport.getText("session.flag"));
		Object sessionUser = sessionMap.get(actionSupport.getText("session.user"));
		Object sessionCurrentTIme = sessionMap.get(actionSupport.getText("session.currentTime"));
		
		System.out.println("Session variables: " + sessionFlag + " | " + sessionUser + " | " + sessionCurrentTIme);
		
		boolean isUserLoggedIn = (sessionFlag != null) && (sessionUser != null) && (sessionCurrentTIme != null);
		
		if(isUserLoggedIn) {
			System.out.println("Session is alive.");
			return actionInvocation.invoke();
		} else {
			System.out.println("Session is invalid.");
			return ActionSupport.INPUT;
		}
	}
}
