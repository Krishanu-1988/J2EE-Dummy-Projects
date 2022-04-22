package in.developershut.bs.action.auth;

import in.developershut.bs.model.User;
import in.developershut.bs.util.MiscUtil;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AuthenticateUser extends ActionSupport implements SessionAware, ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap; 
	
	private User user = new User();

	public String loginUser() {
		if (user.getUserName().equals("admin") && user.getPassWord().equals("password")) {
			
			String currentLoginTime = MiscUtil.getCurrentTimeStamp();
			sessionMap.put(getText("session.flag"), true);
			sessionMap.put(getText("session.user"), user.getUserName());
			sessionMap.put(getText("session.currentTime"), currentLoginTime);
			
			return SUCCESS;
		}
		addActionError(getText("error.auth"));
		return LOGIN;
	}
	
	public String logoutUser() {
		Map<String, Object> sessionMap = getSession();
		if(!sessionMap.isEmpty()) {
			sessionMap.remove(getText("session.flag"));
			sessionMap.remove(getText("session.user"));
			sessionMap.remove(getText("session.currentTime"));
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * @return the sessionMap
	 */
	public SessionMap<String, Object> getSession() {
		return sessionMap;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> sessionMapParam) {
		sessionMap = (SessionMap<String, Object>) sessionMapParam;		
	}

	@Override
	public User getModel() {
		return user;
	}
}
