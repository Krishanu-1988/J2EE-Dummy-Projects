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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userID=");
		builder.append(userID);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", passWord=");
		builder.append(passWord);
		builder.append(", role=");
		builder.append(role);
		builder.append(", organization=");
		builder.append(organization);
		builder.append(", currentLoginTime=");
		builder.append(currentLoginTime);
		builder.append(", lastLoginTime=");
		builder.append(lastLoginTime);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentLoginTime == null) ? 0 : currentLoginTime.hashCode());
		result = prime * result + ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + (int) (userID ^ (userID >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (currentLoginTime == null) {
			if (other.currentLoginTime != null)
				return false;
		} else if (!currentLoginTime.equals(other.currentLoginTime))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}