package com.factoring.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.factoring.core.util.MessageSourceHelper;

public class BaseController {
	@Resource
	public MessageSourceHelper messageSourceHelper;
}
