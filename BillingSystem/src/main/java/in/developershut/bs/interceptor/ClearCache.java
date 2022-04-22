package in.developershut.bs.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ClearCache implements Interceptor {

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

		System.out.println("Inside Clear Cache:");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		return actionInvocation.invoke();
	}
}
