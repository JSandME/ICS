package com.factoring.web.model.downstreamFirms;

public class Credit {

	private String id;
	
	private String username;
	
	private char star;
	
	private int badRecord;
	
	private String createTime;

	private String creatorId;

	private String modifiedTime;

	private String modifierId;

	private String recordState;

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

	public char getStar() {
		return star;
	}

	public void setStar(char star) {
		this.star = star;
	}

	public int getBadRecord() {
		return badRecord;
	}

	public void setBadRecord(int badRecord) {
		this.badRecord = badRecord;
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
