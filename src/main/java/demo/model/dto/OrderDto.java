package demo.model.dto;

import java.util.Date;

public class OrderDto {

	public static class MvcOrderDto{
		
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


		public String getInvoiceNo() {
			return invoiceNo;
		}

		public void setInvoiceNo(String invoiceNo) {
			this.invoiceNo = invoiceNo;
		}

	
		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public Date getPackDate() {
			return packDate;
		}

		public void setPackDate(Date packDate) {
			this.packDate = packDate;
		}

		public Date getInvoiceDate() {
			return invoiceDate;
		}

		public void setInvoiceDate(Date invoiceDate) {
			this.invoiceDate = invoiceDate;
		}

	}
	
	public static class MvcOrderDtlDto{
		
		private String orderNo;
		
		private Integer seqNo;
		
		private String productCode;
		
		private Integer buyItem;
		
		private Integer buyUnitAmt;
		
		private Integer buyTotalAmt;
		
		private Date packDate;

		public String getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}

		public Integer getSeqNo() {
			return seqNo;
		}

		public void setSeqNo(Integer seqNo) {
			this.seqNo = seqNo;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public Integer getBuyItem() {
			return buyItem;
		}

		public void setBuyItem(Integer buyItem) {
			this.buyItem = buyItem;
		}

		public Integer getBuyUnitAmt() {
			return buyUnitAmt;
		}

		public void setBuyUnitAmt(Integer buyUnitAmt) {
			this.buyUnitAmt = buyUnitAmt;
		}

		public Integer getBuyTotalAmt() {
			return buyTotalAmt;
		}

		public void setBuyTotalAmt(Integer buyTotalAmt) {
			this.buyTotalAmt = buyTotalAmt;
		}

		public Date getPackDate() {
			return packDate;
		}

		public void setPackDate(Date packDate) {
			this.packDate = packDate;
		}

	}

}
