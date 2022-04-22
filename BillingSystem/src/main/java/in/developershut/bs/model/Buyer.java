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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buyer [buyerID=");
		builder.append(buyerID);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", contactNo=");
		builder.append(contactNo);
		builder.append(", email=");
		builder.append(email);
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
		result = prime * result + (int) (buyerID ^ (buyerID >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (!(obj instanceof Buyer))
			return false;
		Buyer other = (Buyer) obj;
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
		if (buyerID != other.buyerID)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}