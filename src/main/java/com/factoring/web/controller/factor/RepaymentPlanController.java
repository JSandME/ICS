package com.factoring.web.controller.factor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.factor.RepaymentPlan;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.factor.RepaymentPlanService;

/**
 * 公共视图控制器
 * 
 * @author 
 *   
 **/
@Controller
@RequestMapping("/repaymentPlan")
public class RepaymentPlanController {
	
	private final Log logger = LogFactory.getLog(RepaymentPlanController.class);
	
	@Resource
	private RepaymentPlanService repaymentPlanService;
	
    @RequestMapping(value = "/page")
    @RequiresRoles(value= {RoleSign.FACTOR})
    public String page() {
        return "factor/repaymentPlan";
    }
    
    @RequestMapping(value = "/getRepaymentPlanbyUserName")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
    public String getRepaymentPlanbyUserName(){
    	Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		List<RepaymentPlan> listData = repaymentPlanService.selectRepaymentPlanByState(username);
    	return JsonUtil.dataListToJson(listData);
    }

}