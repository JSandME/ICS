package com.factoring.web.controller.downstreamFirms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.ApplicationUtils;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.downstreamFirms.Credit;
import com.factoring.web.model.downstreamFirms.FinancingApply;
import com.factoring.web.model.factor.Product;
import com.factoring.web.model.factor.RepaymentPlan;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.downstreamFirms.CreditService;
import com.factoring.web.service.downstreamFirms.FinancingApplyService;
import com.factoring.web.service.factor.ProductService;
import com.factoring.web.service.factor.RepaymentPlanService;

@Controller
@RequestMapping("/downstreamFirms")
public class FinancingController {

	private final Log logger = LogFactory.getLog(FinancingController.class);
	
	@Resource
	private ProductService productService;
	
	@Resource
	private CreditService creditService;
	
	@Resource
	private FinancingApplyService financingApplyService;
	
	@Resource
	private RepaymentPlanService repaymentPlanService;

	/**
	 * 访问页面
	 * @return
	 */
	@RequestMapping("/page")
	public String page(Model model){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		Credit credit = creditService.selectCreditByUserName(username);
		
		int validMenoy = 0;
		if(credit != null){
			validMenoy =(int) Math.pow(10, credit.getBadRecord() < 3 ? 6 - credit.getBadRecord():0);
			model.addAttribute("validMenoy", validMenoy);
		}else{
			credit = new Credit();
			credit.setStar("6");
			credit.setBadRecord(0);
			setInfo(credit);
			creditService.insertSelective(credit);
			model.addAttribute("validMenoy", 100000);
		}
		return "downstreamFirms/applyFinancing";
	}
	
	/**
	 * 获取产品信息
	 * @param appAmt
	 * @return
	 */
	@RequestMapping(value = "/getProducts", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getProduct(String appAmt) {
		List<Product> products = productService.selectProductsByAmt(appAmt);
		return JsonUtil.dataListToJson(products);
	}
	
	/**
	 * 申请
	 * @param financingApply
	 * @return
	 */
	@RequestMapping(value = "/apply", produces="application/json; charset=utf-8")
	@ResponseBody
	public String apply(FinancingApply financingApply) {
		try{
			Subject subject = SecurityUtils.getSubject();
			String username = String.valueOf(subject.getPrincipal());
			Credit credit = creditService.selectCreditByUserName(username);
			
			int validMenoy = 0;
			if(credit != null){
				validMenoy =(int) Math.pow(10, credit.getBadRecord() < 3 ? 6 - credit.getBadRecord():0);
			}
			if(validMenoy < Double.valueOf(financingApply.getAppAmt())){
				return "error";
			}
			
			Product product = productService.selectByPrimaryKey(financingApply.getProductId());
			if(product != null){
				String time = ApplicationUtils.getCurrentTime();
				
				financingApply.setUsername(username);
				financingApply.setRate(String.valueOf(product.getRate()));
				financingApply.setAppDate(ApplicationUtils.getCurrentDate());
				financingApply.setState("0");//申请状态——申请中
				financingApply.setCreateTime(time);
				financingApply.setCreatorId(username);
				financingApply.setModifiedTime(time);
				financingApply.setModifierId(username);
				financingApply.setRecordState("0");
				
				financingApplyService.insertSelective(financingApply);
			}else{
				return "error";
			}
			return "";
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 申请信息页
	 * @return
	 */
	@RequestMapping(value = "/applyInfoPage")
	public String applyInfoPage(){
		return "downstreamFirms/applyFinancingInfo";
	}
	
	/**
	 * 申请信息页
	 * @return
	 */
	@RequestMapping(value = "/applyInfoPageByFactor")
	public String applyInfoPageByFactor(){
		return "factor/applyFinancingInfo";
	}
	
	/**
	 * 获取申请信息
	 * @return
	 */
	@RequestMapping(value = "/applyInfo", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getApplyInfo(){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		List<FinancingApply> listdata = financingApplyService.selectFinancingApplyByUserName(username);
		return JsonUtil.dataListToJson(listdata);
	}
	
	/**
	 * 审批申请页
	 * @return
	 */
	@RequestMapping(value = "/approvePage")
	@RequiresRoles(value= {RoleSign.FACTOR})
	public String approvePage(){
		return "factor/approveApply";
	}
	
	/**
	 * 审批申请信息
	 * @return
	 */
	@RequestMapping(value = "/getApproveInfo")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
	public String getApproveInfo(String state){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("state", state);
		
		List<FinancingApply> dataList = financingApplyService.selectFinancingApplyByState(map);
		return JsonUtil.dataListToJson(dataList);
	}
	
	/**
	 * 审批
	 * @return
	 */
	@RequestMapping(value = "/approve")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
	public String approve(FinancingApply financingApply){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		
		String time = ApplicationUtils.getCurrentTime();
		
		financingApply.setCreatorId(username);
		financingApply.setModifiedTime(time);
		
		int i = financingApplyService.updateByPrimaryKeySelective(financingApply);
		System.out.println("financingApply.getState():" + financingApply.getState());
		System.out.println("financingApply.getState().equals()" + financingApply.getState().equals("9"));
		if(i != 0 && !financingApply.getState().equals("9")){
			financingApply = financingApplyService.selectByPrimaryKey(financingApply.getId());
			
			Date date = new Date();//取时间 
		    Calendar calendar = new GregorianCalendar(); 
		    calendar.setTime(date); 
		    calendar.add(calendar.DATE,Integer.valueOf(financingApply.getUseDate()));//把日期往后增加一天.整数往后推,负数往前移动 
		    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
			
			RepaymentPlan model = new RepaymentPlan();
			model.setUsername(username);
			model.setAppId(financingApply.getId());
			model.setBeginDate(ApplicationUtils.getCurrentDate());
			model.setEndDate((new SimpleDateFormat("yyyy-MM-dd")).format(date));
			model.setAppAmt(financingApply.getAppAmt());
			model.setPayedCorpus("0");
			model.setUnpayCorpus(financingApply.getAppAmt());
			model.setRepayAccrual(String.valueOf(Double.valueOf(financingApply.getRate()) * 0.0001 
					* Double.valueOf(financingApply.getAppAmt()) * Double.valueOf(financingApply.getUseDate())));
			model.setPayedAccrual("0");
			model.setRate(financingApply.getRate());
			model.setRepayState("0");
			model.setCreateTime(time);
			model.setCreatorId(username);
			model.setModifiedTime(time);
			model.setModifierId(username);
			model.setRecordState("0");
			repaymentPlanService.insertSelective(model);
			return "";
		}else{
			if(financingApply.getState().equals("9")){
				return "";
			}
		}
		return "error";
	}
	
	
	@RequestMapping(value = "/dealWith", produces="application/json; charset=utf-8")
	@ResponseBody
	public String dealWith() {
		return "deal with financing";
	}
	
	public Credit setInfo(Credit record){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		
		String time = ApplicationUtils.getCurrentTime();
		
		record.setUsername(username);
		record.setCreateTime(time);
		record.setCreatorId(username);
		record.setModifiedTime(time);
		record.setModifierId(username);
		record.setRecordState("0");
		
		return record;
	}

}
