package demo.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MvcOrderDtlEntityPkey implements Serializable {
	
	private String orderNo;
	
	private Integer seqNo;
	
	
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public Integer getSeqNo() {
		return seqNo;
	}


}
