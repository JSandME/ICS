package com.factoring.web.model;

/**
 * @Title Response
 * @author WUSINAN
 * @date 2017年3月30日 
 * Description: 接口返回参数
 */
public class Response {
	public Response() {
		super();
	}

	public Response(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public Response(String status, Object data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}

	private String status;
	private Object data;
	private String msg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
