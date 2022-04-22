package in.developershut.bs.model;

import javax.persistence.*;

@Entity
@Table(name = "T_VAT")
public class VAT extends Tax {

	@Basic
	private double percentage;

	public void setPercentage(double param) {
		this.percentage = param;
	}

	public double getPercentage() {
		return percentage;
	}

}