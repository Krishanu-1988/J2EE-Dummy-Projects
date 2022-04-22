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

}