package com.factoring.web.model.factor;

import javax.validation.constraints.NotNull;

/**
 * 用户模型
 * 
 * @author 
 *   
 **/
public class Product {
    private String id;

    private String username;
    
    @NotNull
    private String productName;

    @NotNull
    private double minAmt;
    
    @NotNull
    private double maxAmt;
    
    @NotNull
    private double rate;

    @NotNull
    private int useDate;

    private String createTime;
    
    private String creatorId;
    
    private String modifiedTime;
    
    private String modifierId;
    
    private String recordState;

    public Product() {
    	
    }

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getMinAmt() {
		return minAmt;
	}


	public void setMinAmt(double minAmt) {
		this.minAmt = minAmt;
	}


	public double getMaxAmt() {
		return maxAmt;
	}


	public void setMaxAmt(double maxAmt) {
		this.maxAmt = maxAmt;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public int getUseDate() {
		return useDate;
	}


	public void setUseDate(int useDate) {
		this.useDate = useDate;
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