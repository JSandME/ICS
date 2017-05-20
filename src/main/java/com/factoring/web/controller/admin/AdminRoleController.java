package com.factoring.web.controller.admin;

import java.util.List;
import java.util.Map;

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

import com.alibaba.druid.stat.TableStat.Mode;
import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.Role;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.RoleService;

/**
 * admin控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/adminRole")
public class AdminRoleController{
	
	private final Log logger = LogFactory.getLog(AdminRoleController.class);
	
	@Resource
	private RoleService roleService;

	/**
	 * admin角色role页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/role")
	//@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
    public String index(HttpServletRequest request,Model model) {
        return "admin/role";
    }
	
	/**
	 * role页面获取类
	 * @return
	 */
	@RequestMapping("/getDate")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String getRoles()
    {
		List<Role> allRole = roleService.selectAllRole();
        return JsonUtil.dataListToJson(allRole);
    }
	
	/**
	 * role页面获取类
	 * @return
	 */
	@RequestMapping("/getRole")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public Role getRolebyId(Long id)
	{
		Role role = roleService.selectByPrimaryKey(id);
		return role;
	}
	
	/**
	 * 更新role表
	 * @param role
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String updateRole(@Valid Role role, BindingResult result, Model model){
		try{
			if (result.hasErrors()) {
	            return result.getFieldError().getDefaultMessage();
	        }
			int flag = roleService.updateByPrimaryKeySelective(role);
			if(flag == 0){
				return "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "";
	}
	
	/**
	 * 获取所有Role
	 * @return
	 */
	@RequestMapping(value="/getRoleName", method = RequestMethod.GET)
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String getRoleName(){
		List listdata = RoleSign.getClassFields();
		logger.info(JsonUtil.dataListToJson(listdata));
		return JsonUtil.dataListToJson(listdata);
	}
	
	/**
	 * 获取所有Role
	 * @return
	 */
	@RequestMapping("/deleteRole")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String deleteRoleById(@Valid Long id){
		try{
			System.out.println("id：" + id);
			int flag = roleService.deleteByPrimaryKey(id);
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
