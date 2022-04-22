package in.developershut.bs.model;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "T_USER")
public class User {

	@Id
	@GeneratedValue
	private long userID;
	@Basic
	private String userName;
	@Basic
	private String passWord;
	@Basic
	private String role;
	@ManyToOne(cascade = ALL)
	@JoinColumn(name = "organization_companyID", referencedColumnName = "companyID")
	private Organization organization;
	@Basic
	@Temporal(TIMESTAMP)
	private Calendar currentLoginTime;
	@Basic
	@Temporal(TIMESTAMP)
	private Calendar lastLoginTime;
	public long getUserID() {
		return userID;
	}

	public void setUserID(long id) {
		this.userID = id;
	}

	public void setUserName(String param) {
		this.userName = param;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassWord(String param) {
		this.passWord = param;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setRole(String param) {
		this.role = param;
	}

	public String getRole() {
		return role;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization param) {
		this.organization = param;
	}

	public void setCurrentLoginTime(Calendar param) {
		this.currentLoginTime = param;
	}

	public Calendar getCurrentLoginTime() {
		return currentLoginTime;
	}

	public void setLastLoginTime(Calendar param) {
		this.lastLoginTime = param;
	}

	public Calendar getLastLoginTime() {
		return lastLoginTime;
	}

}