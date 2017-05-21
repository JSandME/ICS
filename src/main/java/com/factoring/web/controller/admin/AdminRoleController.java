package com.factoring.web.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
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
	@RequestMapping(value = "/getDate", produces="application/json; charset=utf-8")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN )
	public String getRoles(HttpServletResponse response)
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
	public Role getRolebyId(String id)
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
	public String updateRole(@Valid Role role, BindingResult result, Model model,String roleName,String permissions){
		try{
			if(permissions != null && permissions.length() > 0){
				JSONArray array = JSONArray.fromObject(permissions);
				List<Map> listData = new ArrayList<Map>();
				for (int i = 0; i < array.size(); i++) {
					JSONObject object = array.getJSONObject(i);
					Map<String, String> map = new HashMap<String, String>();
					map.put("role_id", role.getId());
					map.put("permission_id", (String)object.get("id"));
					listData.add(map);
				}
				System.out.println(JsonUtil.dataListToJson(listData));
				roleService.insertPermissionsByRoleId(listData);
			}
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
	public String deleteRoleById(@Valid String id){
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
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println(list.toString());
	}
}
