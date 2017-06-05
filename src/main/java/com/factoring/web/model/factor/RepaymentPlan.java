package com.factoring.web.model.factor;

import javax.validation.constraints.NotNull;

/**
 * 用户模型
 * 
 * @author 
 *   
 **/
public class RepaymentPlan {
    private String id;
    private String name;
    private String username;
    private String appId;
    private String beginDate;
    private String endDate;
    private String appAmt;
    private String payedCorpus;
    private String unpayCorpus;
    private String repayAccrual;
    private String payedAccrual;
    private String rate;
    private String repayState;
    private String createTime;
    private String creatorId;
    private String modifiedTime;
    private String modifierId;
    private String recordState;

    public RepaymentPlan() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAppAmt() {
		return appAmt;
	}

	public void setAppAmt(String appAmt) {
		this.appAmt = appAmt;
	}

	public String getPayedCorpus() {
		return payedCorpus;
	}

	public void setPayedCorpus(String payedCorpus) {
		this.payedCorpus = payedCorpus;
	}

	public String getUnpayCorpus() {
		return unpayCorpus;
	}

	public void setUnpayCorpus(String unpayCorpus) {
		this.unpayCorpus = unpayCorpus;
	}

	public String getRepayAccrual() {
		return repayAccrual;
	}

	public void setRepayAccrual(String repayAccrual) {
		this.repayAccrual = repayAccrual;
	}

	public String getPayedAccrual() {
		return payedAccrual;
	}

	public void setPayedAccrual(String payedAccrual) {
		this.payedAccrual = payedAccrual;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRepayState() {
		return repayState;
	}

	public void setRepayState(String repayState) {
		this.repayState = repayState;
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