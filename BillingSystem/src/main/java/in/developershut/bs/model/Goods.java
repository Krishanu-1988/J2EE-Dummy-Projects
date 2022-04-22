package in.developershut.bs.model;

import javax.persistence.*;

@Entity
@Table(name = "T_GOODS")
public class Goods {

	@Id
	@GeneratedValue
	private long goodsID;
	@Basic
	private String name;
	@Basic
	private String description;
	@Basic
	private String manufacturer;
	@Basic
	private String serialID;
	@Basic
	private double rate;

	public long getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(long id) {
		this.goodsID = id;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getDescription() {
		return description;
	}

	public void setManufacturer(String param) {
		this.manufacturer = param;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setSerialID(String param) {
		this.serialID = param;
	}

	public String getSerialID() {
		return serialID;
	}

	public void setRate(double param) {
		this.rate = param;
	}

	public double getRate() {
		return rate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsID=");
		builder.append(goodsID);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", manufacturer=");
		builder.append(manufacturer);
		builder.append(", serialID=");
		builder.append(serialID);
		builder.append(", rate=");
		builder.append(rate);
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (goodsID ^ (goodsID >>> 32));
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((serialID == null) ? 0 : serialID.hashCode());
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
		if (!(obj instanceof Goods))
			return false;
		Goods other = (Goods) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (goodsID != other.goodsID)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (serialID == null) {
			if (other.serialID != null)
				return false;
		} else if (!serialID.equals(other.serialID))
			return false;
		return true;
	}

}