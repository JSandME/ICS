package com.factoring.web.controller.factor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.ApplicationUtils;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.controller.admin.AdminRoleController;
import com.factoring.web.model.User;
import com.factoring.web.model.factor.Product;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.factor.ProductService;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author 
 *   
 **/
@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final Log logger = LogFactory.getLog(AdminRoleController.class);
	
	@Resource
	private ProductService productService;

    @RequestMapping("/page")
    public String page() {
        return "factor/product";	
    }

	@RequestMapping(value = "/getDate", produces="application/json; charset=utf-8")
	@ResponseBody
	@RequiresRoles(value= RoleSign.FACTOR)
	public String getProducts(HttpServletResponse response)
    {
		Subject subject = SecurityUtils.getSubject();
		String username = String.valueOf(subject.getPrincipal());
		
		List<Product> allProduct = productService.selectAllProduct(username);
		System.out.println("aaaaa============>" + JsonUtil.dataListToJson(allProduct));
        return JsonUtil.dataListToJson(allProduct);
    }
	
	@RequestMapping("/getProduct")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
	public Product getUserbyId(String id)
	{
		Product product = productService.selectByPrimaryKey(id);
		return product;
	}
	
	/**
	 * 
	 * @param role
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateProduct")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
	public String updateProduct(@Valid Product product, BindingResult result, Model model){
		try{
			setInfo(product);//set时间
			if (result.hasErrors()) {
	            return result.getFieldError().getDefaultMessage();
	        }
			int flag = productService.updateByPrimaryKeySelective(product);
			if(flag == 0){
				if(productService.insertSelective(product) != 0){
					return "";
				}
				return "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/deleteProduct")
	@ResponseBody
	@RequiresRoles(value= {RoleSign.FACTOR})
	public String deleteProductById(@Valid String id){
		try{
			int flag = productService.deleteByPrimaryKey(id);
			if(flag == 0){
				return "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "";
	}
	
	public Product setInfo(Product record){
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