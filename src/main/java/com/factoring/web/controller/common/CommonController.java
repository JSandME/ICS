package com.factoring.web.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共视图控制器
 * 
 * @author 
 *   
 **/
@Controller
public class CommonController {
	
	private final Log logger = LogFactory.getLog(CommonController.class);
	
    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "index";
    }

}