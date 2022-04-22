package in.developershut.bs.action.navigation;

import in.developershut.bs.action.ApplicationConstants;

import com.opensymphony.xwork2.ActionSupport;

public class NavigationAction extends ActionSupport implements
		ApplicationConstants {

	private static final long serialVersionUID = 1L;

	public String navigateHome() {
		return HOMEPAGE;
	}

	public String navigateTechSupport() {
		return TECHSUPPORT;
	}

	public String navigateLogin() {
		return LOGINPAGE;
	}

	public String navigateUserHome() {
		return USERHOME;
	}

	public String navigateSettings() {
		return SETTINGS;
	}

	public String navigateBilling() {
		return BILLING;
	}

	public String navigateReports() {
		return REPORTS;
	}
}
