package in.developershut.bs.model;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_VAT")
public class VAT extends Tax {
	
	@Basic
	private String percentage;

	public VAT() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(percentage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VAT other = (VAT) obj;
		return Objects.equals(percentage, other.percentage);
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String param) {
		this.percentage = param;
	}
}