package in.developershut.bs.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "T_INVOICE")
public class Invoice {

	@Id
	@GeneratedValue
	private long invoiceID;
	@Basic
	private String invoiceNo;
	@Basic
	private String totalAmountInWords;
	@Basic
	private String buyersCopyPath;
	@Basic
	private String ownersCopyPath;
	@Basic
	private String orderNo;
	@Basic
	private double totalAmount;
	@OneToMany(cascade = ALL)
	@JoinColumn
	private Collection<Tax> tax;
	@Basic
	@Temporal(DATE)
	private Calendar invoiceDate;
	@Basic
	@Temporal(DATE)
	private Calendar orderDate;
	public long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(long id) {
		this.invoiceID = id;
	}

	public void setInvoiceNo(String param) {
		this.invoiceNo = param;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setTotalAmountInWords(String param) {
		this.totalAmountInWords = param;
	}

	public String getTotalAmountInWords() {
		return totalAmountInWords;
	}

	public void setBuyersCopyPath(String param) {
		this.buyersCopyPath = param;
	}

	public String getBuyersCopyPath() {
		return buyersCopyPath;
	}

	public void setOwnersCopyPath(String param) {
		this.ownersCopyPath = param;
	}

	public String getOwnersCopyPath() {
		return ownersCopyPath;
	}

	public void setOrderNo(String param) {
		this.orderNo = param;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setTotalAmount(double param) {
		this.totalAmount = param;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public Collection<Tax> getTax() {
		return tax;
	}

	public void setTax(Collection<Tax> param) {
		this.tax = param;
	}

	public void setInvoiceDate(Calendar param) {
		this.invoiceDate = param;
	}

	public Calendar getInvoiceDate() {
		return invoiceDate;
	}

	public void setOrderDate(Calendar param) {
		this.orderDate = param;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [invoiceID=");
		builder.append(invoiceID);
		builder.append(", invoiceNo=");
		builder.append(invoiceNo);
		builder.append(", totalAmountInWords=");
		builder.append(totalAmountInWords);
		builder.append(", buyersCopyPath=");
		builder.append(buyersCopyPath);
		builder.append(", ownersCopyPath=");
		builder.append(ownersCopyPath);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", tax=");
		builder.append(tax);
		builder.append(", invoiceDate=");
		builder.append(invoiceDate);
		builder.append(", orderDate=");
		builder.append(orderDate);
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
		result = prime * result + ((buyersCopyPath == null) ? 0 : buyersCopyPath.hashCode());
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result + (int) (invoiceID ^ (invoiceID >>> 32));
		result = prime * result + ((invoiceNo == null) ? 0 : invoiceNo.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((ownersCopyPath == null) ? 0 : ownersCopyPath.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((totalAmountInWords == null) ? 0 : totalAmountInWords.hashCode());
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
		if (!(obj instanceof Invoice))
			return false;
		Invoice other = (Invoice) obj;
		if (buyersCopyPath == null) {
			if (other.buyersCopyPath != null)
				return false;
		} else if (!buyersCopyPath.equals(other.buyersCopyPath))
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceID != other.invoiceID)
			return false;
		if (invoiceNo == null) {
			if (other.invoiceNo != null)
				return false;
		} else if (!invoiceNo.equals(other.invoiceNo))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (ownersCopyPath == null) {
			if (other.ownersCopyPath != null)
				return false;
		} else if (!ownersCopyPath.equals(other.ownersCopyPath))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		if (totalAmountInWords == null) {
			if (other.totalAmountInWords != null)
				return false;
		} else if (!totalAmountInWords.equals(other.totalAmountInWords))
			return false;
		return true;
	}
	
}