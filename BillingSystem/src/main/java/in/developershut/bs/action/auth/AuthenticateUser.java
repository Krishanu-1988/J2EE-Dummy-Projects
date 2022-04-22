package in.developershut.bs.action.auth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AuthenticateUser extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private SessionMap<String, Object> sessionMap; 

	public String loginUser() {
		if (getUsername().equals("admin") && getPassword().equals("password")) {
			
			
			
			return SUCCESS;
		}
		addActionError(getText("error.auth"));
		return LOGIN;
	}
	
	public String logoutUser() {
		Map<String, Object> sessionMap = getSession();
		if(!sessionMap.isEmpty()) {
			sessionMap.remove("loginFlag");
			System.out.println(sessionMap.get("loginFlag"));
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		// Set Session
		sessionMap = (SessionMap<String, Object>) sessionMapParam;

		// Get current login time
		Calendar currentDateTime = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		dateFormat.setCalendar(currentDateTime);
		String currentLoginTime = dateFormat.format(currentDateTime.getTime());

		// Set session variables
		sessionMap.put("loginFlag", true);
		System.out.println(getUsername());
		sessionMap.put("userName", getUsername());
		sessionMap.put("currentLoginTime", currentLoginTime);
	}
}
