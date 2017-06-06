package com.factoring.web.controller.factor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.ApplicationUtils;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.factor.RepaymentDetail;
import com.factoring.web.model.factor.RepaymentPlan;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.factor.RepaymentDetailService;
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
	
	@Resource
	private RepaymentDetailService repaymentDetailService;
	
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
    
    @RequestMapping(value = "/repayment")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
    public String repayment(RepaymentDetail detail){
    	RepaymentPlan plan = repaymentPlanService.selectByPrimaryKey(detail.getPanId());
    	
    	if(plan != null){
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    		Subject subject = SecurityUtils.getSubject();
    		String username = String.valueOf(subject.getPrincipal());
    		String time = ApplicationUtils.getCurrentTime();
    		
    		if(detail.getPayCorpus() != "0"){
    			try{
		    		plan.setBeginDate(ApplicationUtils.getCurrentDate());
		    		plan.setPayedCorpus(String.valueOf(Double.valueOf(plan.getPayedCorpus())
		    				+ Double.valueOf(detail.getPayCorpus())));
		    		plan.setUnpayCorpus(String.valueOf(Double.valueOf(plan.getUnpayCorpus())
		    				- Double.valueOf(detail.getPayCorpus())));
		    		plan.setRepayAccrual(String.valueOf(ApplicationUtils.daysOfTwo(
		    				format.parse(ApplicationUtils.getCurrentDate())
		    				, format.parse(plan.getEndDate())) 
		    				* Double.valueOf(plan.getUnpayCorpus()) 
		    				* Double.valueOf(plan.getRate()) 
		    				* 0.0001));
		    		System.out.println("1===>" + Double.valueOf(plan.getUnpayCorpus()));
		    		if(Double.valueOf(plan.getUnpayCorpus()) == 0){
		    			plan.setRepayState("1");
		    		}
    			}catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
    		}
    		plan.setPayedAccrual(String.valueOf(Double.valueOf(plan.getPayedAccrual())
    				+ Double.valueOf(detail.getPayAccrual())));
    		plan.setModifiedTime(time);
    		plan.setModifierId(username);
    		
    		int i = repaymentPlanService.updateByPrimaryKeySelective(plan);
    		if(i != 0){
    		
	    		detail.setRepayDate(ApplicationUtils.getCurrentDate());
	    		detail.setCreateTime(time);
	    		detail.setCreatorId(username);
	    		detail.setModifiedTime(time);
	    		detail.setModifierId(username);
	    		detail.setRecordState("0");
	    		repaymentDetailService.insertSelective(detail);
    		}
    		
    	}
    	
    	return "success";
    }
    
    @RequestMapping(value = "/overDue")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
    public String overDue(RepaymentPlan plan){
    	System.out.println("plan==>" + plan.getAppAmt());
    	Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		String time = ApplicationUtils.getCurrentTime();
		
		plan.setModifiedTime(time);
		plan.setModifierId(username);
    	
    	int i = repaymentPlanService.updateByPrimaryKeySelective(plan);
    	if(i == 0){
    		return "error";
    	}
    	return "success";
    }

}