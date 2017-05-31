package com.factoring.web.util;

import com.factoring.web.controller.common.MessageCommon;
import com.factoring.web.model.Response;

/**
 * @Title ResponseUtil
 * @author WUSINAN
 * @date 2017年3月30日 Description:封装ResponseDTO的工具类
 */
public class ResponseUtil {
	private ResponseUtil() {
	}

	public static Response ConvertToSuccessResponse() {
		Response result = new Response(MessageCommon.STATUS_SUCCESS, MessageCommon.SUCCESS_MESSAGE);
		return result;
	}

	public static Response ConvertToSuccessResponse(Object data) {
		Response result = new Response(MessageCommon.STATUS_SUCCESS, data, MessageCommon.SUCCESS_MESSAGE);
		return result;
	}

	public static Response ConvertToFailResponse() {
		Response result = new Response(MessageCommon.STATUS_FAIL, MessageCommon.FAIL_MESSAGE);
		return result;
	}


	public static Response ConvertToFailResponse(String status) {
		Response result = new Response(status, MessageCommon.FAIL_MESSAGE);
		return result;
	}

	public static Response ConvertToFailResponse(String status, String msg) {
		Response result = new Response(status, msg);
		return result;
	}
}
