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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineItem [lineItemID=");
		builder.append(lineItemID);
		builder.append(", description=");
		builder.append(description);
		builder.append(", serialNo=");
		builder.append(serialNo);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", buyer=");
		builder.append(buyer);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", invoice=");
		builder.append(invoice);
		builder.append(", vAT=");
		builder.append(vAT);
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + (int) (lineItemID ^ (lineItemID >>> 32));
		result = prime * result + (int) (quantity ^ (quantity >>> 32));
		result = prime * result + serialNo;
		result = prime * result + ((vAT == null) ? 0 : vAT.hashCode());
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
		if (!(obj instanceof LineItem))
			return false;
		LineItem other = (LineItem) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (buyer == null) {
			if (other.buyer != null)
				return false;
		} else if (!buyer.equals(other.buyer))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (lineItemID != other.lineItemID)
			return false;
		if (quantity != other.quantity)
			return false;
		if (serialNo != other.serialNo)
			return false;
		if (vAT == null) {
			if (other.vAT != null)
				return false;
		} else if (!vAT.equals(other.vAT))
			return false;
		return true;
	}
}