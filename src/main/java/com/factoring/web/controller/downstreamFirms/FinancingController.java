<<<<<<< HEAD
package com.factoring.web.controller.downstreamFirms;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
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
import com.factoring.web.service.downstreamFirms.CreditService;
import com.factoring.web.service.downstreamFirms.FinancingApplyService;
import com.factoring.web.service.factor.ProductService;

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
			credit.setStar('6');
			credit.setBadRecord(0);
			setInfo(credit);
			creditService.insertSelective(credit);
			model.addAttribute("validMenoy", 100000);
		}
		return "downstreamFirms/applyFinancing";
	}
	
	@RequestMapping(value = "/getProducts", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getProduct(String appAmt) {
		List<Product> products = productService.selectProductsByAmt(appAmt);
		return JsonUtil.dataListToJson(products);
	}
	
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
				financingApply.setRate(product.getRate());
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
	
	@RequestMapping(value = "/applyInfoPage")
	public String applyInfoPage(){
		return "downstreamFirms/applyFinancingInfo";
	}
	
	@RequestMapping(value = "/applyInfo", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getApplyInfo(){
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		List<FinancingApply> listdata = financingApplyService.selectFinancingApplyByUserName(username);
		return JsonUtil.dataListToJson(listdata);
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
=======
package com.factoring.web.controller.downstreamFirms;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.entity.ServiceException;
import com.factoring.core.util.ApplicationUtils;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.controller.common.MessageCommon;
import com.factoring.web.model.Response;
import com.factoring.web.model.downstreamFirms.Credit;
import com.factoring.web.model.downstreamFirms.FinancingApply;
import com.factoring.web.model.factor.Product;
import com.factoring.web.service.downstreamFirms.CreditService;
import com.factoring.web.service.downstreamFirms.FinancingApplyService;
import com.factoring.web.service.factor.ProductService;
import com.factoring.web.util.ResponseUtil;

@Controller
@RequestMapping("/downstreamFirms")
public class FinancingController {

	private final Log logger = LogFactory.getLog(FinancingController.class);
	
	@Resource
	private ProductService productService;
	
	@Resource
	private CreditService creditService;
	
	@Resource
	private FinancingApplyService financingService;

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
			credit.setStar('6');
			credit.setBadRecord(0);
			setInfo(credit);
			creditService.insertSelective(credit);
			model.addAttribute("validMenoy", 100000);
		}
		return "downstreamFirms/applyFinancing";
	}
	
	@RequestMapping(value = "/getProducts", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getProduct(String appAmt) {
		List<Product> products = productService.selectProductsByAmt(appAmt);
		System.out.println(appAmt);
		System.out.println(JsonUtil.dataListToJson(products));
		return JsonUtil.dataListToJson(products);
	}
	
	@RequestMapping(value = "/apply", produces="application/json; charset=utf-8")
	@ResponseBody
	public Response apply(FinancingApply financingApply) {
		try {
			financingService.insert(financingApply);
			return ResponseUtil.ConvertToSuccessResponse();
		}catch(ServiceException e) {
			logger.error(e.getMessage());
			return ResponseUtil.ConvertToFailResponse(MessageCommon.STATUS_FINANCING_APPLY_FAIL, MessageCommon.FAIL_FINANCING_APPLY);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return ResponseUtil.ConvertToFailResponse();
		}
		
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
>>>>>>> fde67fc1af381be19306679eaaef36d04c229ffa
