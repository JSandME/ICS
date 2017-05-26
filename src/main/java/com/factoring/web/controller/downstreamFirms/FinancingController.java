package com.factoring.web.controller.downstreamFirms;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.web.service.common.UserService;

@Controller
@RequestMapping("/downstreamFirms")
public class FinancingController {

	private final Log logger = LogFactory.getLog(FinancingController.class);
	
	@Resource
	private UserService userService;

	/**
	 * 访问页面
	 * @return
	 */
	@RequestMapping("/page")
	public String page(){
		return "downstreamFirms/applyFinancing";
	}
	
	@RequestMapping(value = "/apply", produces="application/json; charset=utf-8")
	@ResponseBody
	public String apply() {
		return "apply financing";
	}
	
	@RequestMapping(value = "/dealWith", produces="application/json; charset=utf-8")
	@ResponseBody
	public String dealWith() {
		return "deal with financing";
	}
}
