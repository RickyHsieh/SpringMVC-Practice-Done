package demo.model.entity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MVC_ORDER")
public class MvcOrderEntity {

	@Id
	private String orderNo;

	private Date orderDate;

	private String orderStatus;

	private Integer totalAmt;

	private String payType;

	private String packNo;

	private Date packDate;

	private String invoiceNo;

	private Date invoiceDate;

	private String remark;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "mvcOrderEntity")
	private List<MvcOrderDtlEntity> mvcOrderDtlEntity;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Integer totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPackNo() {
		return packNo;
	}

	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}

	public Date getPackDate() {
		return packDate;
	}

	public void setPackDate(Date packDate) {
		this.packDate = packDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<MvcOrderDtlEntity> getMvcOrderDtlEntity() {
		return mvcOrderDtlEntity;
	}

	public void setMvcOrderDtlEntity(List<MvcOrderDtlEntity> mvcOrderDtlEntity) {
		this.mvcOrderDtlEntity = mvcOrderDtlEntity;
	}

	public String getFmtInvoiceDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = null;
		if (this.invoiceDate != null) {
			time = sdf.format(invoiceDate);
		} else {
			time = "";
		}
		return time;
	}

	public String getFmtOrderDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = null;
		if (this.orderDate != null) {
			time = sdf.format(orderDate);
		} else {
			time = "";
		}
		return time;
	}

	public String fmtDecimal(int num) {

		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(num);

	}

	public String getFmtTotalAmt() {
		return fmtDecimal(totalAmt);
	}

}
