package com.factoring.web.model.factor;

import javax.validation.constraints.NotNull;


/**
 * 用户模型
 * 
 * @author 
 *   
 **/
public class RepaymentDetail {
	@NotNull
    private String id;
    private String panId;
    private String repayDate;
    private String payCorpus;
    private String payAccrual;
    private String createTime;
    private String creatorId;
    private String modifiedTime;
    private String modifierId;
    private String recordState;

    public RepaymentDetail() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public String getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}

	public String getPayCorpus() {
		return payCorpus;
	}

	public void setPayCorpus(String payCorpus) {
		this.payCorpus = payCorpus;
	}

	public String getPayAccrual() {
		return payAccrual;
	}

	public void setPayAccrual(String payAccrual) {
		this.payAccrual = payAccrual;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

}