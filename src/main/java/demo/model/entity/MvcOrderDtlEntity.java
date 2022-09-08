package demo.model.entity;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MVC_ORDER_DTL")
public class MvcOrderDtlEntity {

	@EmbeddedId
	private MvcOrderDtlEntityPkey pk;

	private String productCode;

	private Integer buyItem;

	private Integer buyUnitAmt;

	private Integer buyTotalAmt;

	private Date packDate;

	@ManyToOne
	@JoinColumn(name = "orderNo", referencedColumnName = "orderNo", insertable = false, updatable = false)
	private MvcOrderEntity mvcOrderEntity;
	
	@ManyToOne
	@JoinColumn(name = "productCode", referencedColumnName = "prodCode", insertable = false, updatable = false)
	private MvcProductEntity mvcProductEntity;
	
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public MvcOrderDtlEntityPkey getPk() {
		return pk;
	}

	public void setPk(MvcOrderDtlEntityPkey pk) {
		this.pk = pk;
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

	public MvcOrderEntity getMvcOrderEntity() {
		return mvcOrderEntity;
	}

	public void setMvcOrderEntity(MvcOrderEntity mvcOrderEntity) {
		this.mvcOrderEntity = mvcOrderEntity;
	}


	public MvcProductEntity getMvcProductEntity() {
		return mvcProductEntity;
	}

	public void setMvcProductEntity(MvcProductEntity mvcProductEntity) {
		this.mvcProductEntity = mvcProductEntity;
	}

	public String getFmtPackDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = null;
		if (this.packDate != null) {
			time = sdf.format(packDate);
		} else {
			time = "";
		}
		return time;
	}
	
	public String fmtDecimal(int num) {
		
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(num);
		
	}
	public String getFmtBuyUnitAmt() {
		 return fmtDecimal(buyUnitAmt);
	}
	
	public String getFmtBuyTotalAmt() {
		return fmtDecimal(buyTotalAmt);
	}

}
