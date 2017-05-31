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
import com.factoring.web.model.factor.Product;
import com.factoring.web.service.downstreamFirms.CreditService;
import com.factoring.web.service.factor.ProductService;

@Controller
@RequestMapping("/downstreamFirms")
public class FinancingController {

	private final Log logger = LogFactory.getLog(FinancingController.class);
	
	@Resource
	private ProductService productService;
	
	@Resource
	private CreditService creditService;

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
	public String apply() {
		return "apply financing";
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
