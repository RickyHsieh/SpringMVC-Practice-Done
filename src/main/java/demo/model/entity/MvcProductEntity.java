package demo.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MVC_PRODUCT")
public class MvcProductEntity {

	@Id
	private String prodCode;

	private String prodName;
	
	private String prodDesc;

	private Integer prodUnitAmt;

	private String prodRemark;

	private Date creTime;

	private String creUser;

	private Date updTime;

	private String updUser;
	
	@OneToMany(mappedBy = "mvcProductEntity")
	private List<MvcOrderDtlEntity> mvcOrderDtlEntity;

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Integer getProdUnitAmt() {
		return prodUnitAmt;
	}

	public void setProdUnitAmt(Integer prodUnitAmt) {
		this.prodUnitAmt = prodUnitAmt;
	}

	

	public String getProdRemark() {
		return prodRemark;
	}

	public void setProdRemark(String prodRemark) {
		this.prodRemark = prodRemark;
	}

	public Date getCreTime() {
		return creTime;
	}

	public void setCreTime(Date creTime) {
		this.creTime = creTime;
	}

	public String getCreUser() {
		return creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public List<MvcOrderDtlEntity> getMvcOrderDtlEntity() {
		return mvcOrderDtlEntity;
	}

	public void setMvcOrderDtlEntity(List<MvcOrderDtlEntity> mvcOrderDtlEntity) {
		this.mvcOrderDtlEntity = mvcOrderDtlEntity;
	}

	
	

}
