package in.developershut.bs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_TAX")
public class Tax {

	@Id
	@GeneratedValue
	private long taxID;
	public long getTaxID() {
		return taxID;
	}

	public void setTaxID(long id) {
		this.taxID = id;
	}

}