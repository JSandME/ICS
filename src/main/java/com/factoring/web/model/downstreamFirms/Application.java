package com.factoring.web.model.downstreamFirms;

import javax.validation.constraints.NotNull;

public class Application {
	
	@NotNull
	private String id;
	
	private String userName;
	
	private String roleName;
	
	private String productID;
	
	private String appAmt;
	
	private String rate;
	
	private String useDate;
	
	private String appDate;
	
	private String state;
	
	private String createdTime;
	
	private String creatorID;
	
	private String modifiedTime;
	
	private String modifierID;
	
	private String recordState;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getAppAmt() {
		return appAmt;
	}

	public void setAppAmt(String appAmt) {
		this.appAmt = appAmt;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(String creatorID) {
		this.creatorID = creatorID;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifierID() {
		return modifierID;
	}

	public void setModifierID(String modifierID) {
		this.modifierID = modifierID;
	}

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	
}
