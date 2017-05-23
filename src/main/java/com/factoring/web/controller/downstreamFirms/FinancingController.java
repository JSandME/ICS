package com.factoring.web.controller.downstreamFirms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class FinancingController {

	@RequestMapping(value = "/manage", produces="application/json; charset=utf-8")
	@ResponseBody
	public String manage() {
		return "financing management";
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
