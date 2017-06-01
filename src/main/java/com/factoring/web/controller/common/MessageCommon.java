package com.factoring.web.controller.common;


public class MessageCommon {

	public static final String STATUS_SUCCESS = "0000";// 返回成功
	public static final String STATUS_FAIL = "9999";// 返回失败
	public static final String STATUS_USER_IS_EXIST = "1000";// 用户已存在
	public static final String STATUS_USER_NOT_EXIST = "1002";// 用户不存在
	public static final String STATUS_PASSWORD_WRONG = "1003";// 密码错误
	public static final String STATUS_PHONENUMBER_EXIST = "1004";// 手机号已注册
	public static final String STATUS_PARAMETER_WRONG = "1005";// 参数错误或者为空
	public static final String STATUS_FINANCING_APPLY_FAIL = "1006";//申请失败

	public static final String SUCCESS_MESSAGE = "返回成功";
	public static final String FAIL_MESSAGE = "返回失败";
	public static final String FAIL_MESSAGE_PARAMETER = "参数错误或者为空";
	public static final String FAIL_MESSAGE_USER_NOT_EXIST = "用户不存在";
	public static final String FAIL_MESSAGE_USER_IS_EXIST = "用户已存在";
	public static final String FAIL_MESSAGE_PASSWORD_WRONG = "密码错误";
	public static final String FAIL_FINANCING_APPLY = "申请失败";

	private MessageCommon() {
	}
}

