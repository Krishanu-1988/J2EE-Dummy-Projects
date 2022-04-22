package in.developershut.bs.model;

import javax.persistence.*;

@Entity
@Table(name = "T_BUYER")
public class Buyer {

	@Id
	@GeneratedValue
	private long buyerID;
	@Basic
	private String firstName;
	@Basic
	private String lastName;
	@Basic
	private String addressLine1;
	@Basic
	private String addressLine2;
	@Basic
	private String city;
	@Basic
	private String contactNo;
	@Basic
	private String email;

	public long getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(long id) {
		this.buyerID = id;
	}

	public void setFirstName(String param) {
		this.firstName = param;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String param) {
		this.lastName = param;
	}

	public String getLastName() {
		return lastName;
	}

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

	public void setContactNo(String param) {
		this.contactNo = param;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return email;
	}

}