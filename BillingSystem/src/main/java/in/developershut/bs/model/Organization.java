package in.developershut.bs.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORGANIZATION")
public class Organization {

	@Basic
	private String addressLine1;
	@Basic
	private String addressLine2;
	@Basic
	private String city;
	@Basic
	private String state;
	@Basic
	private String contactNo1;
	@Basic
	private String contactNo2;
	@Basic
	private String vATNo;
	@Basic
	private String cSTNo;
	@Basic
	private String declaration;
	@Id
	@GeneratedValue
	private long companyID;
	@Basic
	private String companyName;
	@Basic
	private String companyLogoPath;
	
	public void setAddressLine1(String param) {
		this.addressLine1 = param;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine2(String param) {
		this.addressLine2 = param;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setCity(String param) {
		this.city = param;
	}

	public String getCity() {
		return city;
	}

	public void setState(String param) {
		this.state = param;
	}

	public String getState() {
		return state;
	}

	public void setContactNo1(String param) {
		this.contactNo1 = param;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo2(String param) {
		this.contactNo2 = param;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setVATNo(String param) {
		this.vATNo = param;
	}

	public String getVATNo() {
		return vATNo;
	}

	public void setCSTNo(String param) {
		this.cSTNo = param;
	}

	public String getCSTNo() {
		return cSTNo;
	}

	public void setDeclaration(String param) {
		this.declaration = param;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setCompanyID(long param) {
		this.companyID = param;
	}

	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyName(String param) {
		this.companyName = param;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyLogoPath(String param) {
		this.companyLogoPath = param;
	}

	public String getCompanyLogoPath() {
		return companyLogoPath;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Organization [addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", contactNo1=");
		builder.append(contactNo1);
		builder.append(", contactNo2=");
		builder.append(contactNo2);
		builder.append(", vATNo=");
		builder.append(vATNo);
		builder.append(", cSTNo=");
		builder.append(cSTNo);
		builder.append(", declaration=");
		builder.append(declaration);
		builder.append(", companyID=");
		builder.append(companyID);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", companyLogoPath=");
		builder.append(companyLogoPath);
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
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((cSTNo == null) ? 0 : cSTNo.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (companyID ^ (companyID >>> 32));
		result = prime * result + ((companyLogoPath == null) ? 0 : companyLogoPath.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((contactNo1 == null) ? 0 : contactNo1.hashCode());
		result = prime * result + ((contactNo2 == null) ? 0 : contactNo2.hashCode());
		result = prime * result + ((declaration == null) ? 0 : declaration.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((vATNo == null) ? 0 : vATNo.hashCode());
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
		if (!(obj instanceof Organization))
			return false;
		Organization other = (Organization) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (cSTNo == null) {
			if (other.cSTNo != null)
				return false;
		} else if (!cSTNo.equals(other.cSTNo))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (companyID != other.companyID)
			return false;
		if (companyLogoPath == null) {
			if (other.companyLogoPath != null)
				return false;
		} else if (!companyLogoPath.equals(other.companyLogoPath))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (contactNo1 == null) {
			if (other.contactNo1 != null)
				return false;
		} else if (!contactNo1.equals(other.contactNo1))
			return false;
		if (contactNo2 == null) {
			if (other.contactNo2 != null)
				return false;
		} else if (!contactNo2.equals(other.contactNo2))
			return false;
		if (declaration == null) {
			if (other.declaration != null)
				return false;
		} else if (!declaration.equals(other.declaration))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (vATNo == null) {
			if (other.vATNo != null)
				return false;
		} else if (!vATNo.equals(other.vATNo))
			return false;
		return true;
	}
}