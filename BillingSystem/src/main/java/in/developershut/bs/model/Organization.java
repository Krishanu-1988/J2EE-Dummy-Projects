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

}