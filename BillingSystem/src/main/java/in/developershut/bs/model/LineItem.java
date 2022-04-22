package in.developershut.bs.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import in.developershut.bs.model.VAT;

@Entity
@Table(name = "T_LINEITEM")
public class LineItem {

	@Id
	@GeneratedValue(strategy = AUTO)
	private long lineItemID;
	@Basic
	private String description;
	@Basic
	private int serialNo;
	@Basic
	private double amount;
	@Basic
	private long quantity;
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "buyer_buyerID", referencedColumnName = "buyerID")
	private Buyer buyer;
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "goods_goodsID", referencedColumnName = "goodsID")
	private Goods goods;
	@ManyToOne(cascade = ALL)
	@JoinColumn(name = "invoice_invoiceID", referencedColumnName = "invoiceID")
	private Invoice invoice;
	@OneToOne(cascade = ALL)
	@JoinColumn(name = "vAT_taxID", referencedColumnName = "taxID")
	private VAT vAT;

	public long getLineItemID() {
		return lineItemID;
	}

	public void setLineItemID(long id) {
		this.lineItemID = id;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getDescription() {
		return description;
	}

	public void setSerialNo(int param) {
		this.serialNo = param;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setAmount(double param) {
		this.amount = param;
	}

	public double getAmount() {
		return amount;
	}

	public void setQuantity(long param) {
		this.quantity = param;
	}

	public long getQuantity() {
		return quantity;
	}

	public Buyer getBuyer() {
	    return buyer;
	}

	public void setBuyer(Buyer param) {
	    this.buyer = param;
	}

	public Goods getGoods() {
	    return goods;
	}

	public void setGoods(Goods param) {
	    this.goods = param;
	}

	public Invoice getInvoice() {
	    return invoice;
	}

	public void setInvoice(Invoice param) {
	    this.invoice = param;
	}

	public VAT getVAT() {
	    return vAT;
	}

	public void setVAT(VAT param) {
	    this.vAT = param;
	}

}