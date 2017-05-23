package com.factoring.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.Permission;
import com.factoring.web.security.PermissionSign;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.PermissionService;

/**
 * admin控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/adminPermission")
public class AdminPermissionController{
	
	private final Log logger = LogFactory.getLog(AdminPermissionController.class);
	
	@Resource
	private PermissionService permissionService;

	@RequestMapping("/permission")
	//@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
    public String index(HttpServletRequest request,Model model) {
        return "admin/permission";
    }
	
	/**
	 * produces = "application/json; charset=utf-8"
	 * 把@ResponseBody默认的 iso-8859-1改为utf-8
	 * @return
	 */
	@RequestMapping(value = "/getDate", produces = "application/json; charset=utf-8")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String getPermissions()
    {
		List<Permission> allPermission = permissionService.selectAllPermission();
        return JsonUtil.dataListToJson(allPermission);
    }
	
	@RequestMapping("/getPermission")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public Permission getPermissionbyId(String id)
	{
		Permission permission = permissionService.selectByPrimaryKey(id);
		return permission;
	}
	
	@RequestMapping("/updatePermission")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String updatePermission(@Valid Permission permission, BindingResult result, Model model){
		try{
			if (result.hasErrors()) {
	            return result.getFieldError().getDefaultMessage();
	        }
			int flag = permissionService.updateByPrimaryKeySelective(permission);
			if(flag == 0){
				if(permissionService.insertSelective(permission) != 0){
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
	
	@RequestMapping(value="/getPermissionName", method = RequestMethod.GET)
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String getPermissionName(){
		List listdata = PermissionSign.getClassFields();
		return JsonUtil.dataListToJson(listdata);
	}
	
	@RequestMapping("/deletePermission")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String deletePermissionById(@Valid String id){
		try{
			System.out.println("id：" + id);
			int flag = permissionService.deleteByPrimaryKey(id);
			if(flag == 0){
				return "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "";
	}

}
