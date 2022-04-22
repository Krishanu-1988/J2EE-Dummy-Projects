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

}