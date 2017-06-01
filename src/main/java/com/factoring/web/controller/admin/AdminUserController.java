package com.factoring.web.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.factoring.core.util.JsonUtil;
import com.factoring.web.model.User;
import com.factoring.web.security.RoleSign;
import com.factoring.web.service.common.UserService;

/**
 * admin控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/adminUser")
public class AdminUserController{
	
	private final Log logger = LogFactory.getLog(AdminRoleController.class);
	
	@Resource
	private UserService userService;

	/**
	 * admin角色role页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/user")
	//@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
    public String index(HttpServletRequest request,Model model) {
        return "admin/user";
    }
	
	/**
	 * role页面获取类
	 * @return
	 */
	@RequestMapping(value = "/getDate", produces="application/json; charset=utf-8")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN )
	public String getUsers(HttpServletResponse response)
    {
		List<User> allUser = userService.selectAllUser();
		List allUserRole = userService.selectAllUserRole();
		int count = 0;
		for (int i = 0; i < allUser.size(); i++) {
			String role = "";
			User user = allUser.get(i);
			for (; count < allUserRole.size();) {
				Map map = (Map) allUserRole.get(count);
				if(map.get("user_id").equals(user.getId())){
					role = (String) map.get("role_id");
					count ++ ;
				}else{
					break;
				}
			}
			
			user.setRole(role);
		}
        return JsonUtil.dataListToJson(allUser);
    }
	
	/**
	 * user页面获取类
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public User getUserbyId(String id)
	{
		User user = userService.selectByPrimaryKey(id);
		return user;
	}
	
	
	/**
	 * 
	 * @param role
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String updateUser(@Valid User user, BindingResult result, Model model){
		try{
			if(user.getRole() != null){ 
				List<Map> listData = new ArrayList<Map>();
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", user.getId());
				map.put("roleId", user.getRole());
				listData.add(map);
				userService.deleteRoleByUserId(user.getId());
				userService.insertRoleByUserId(listData);
			}
			if (result.hasErrors()) {
	            return result.getFieldError().getDefaultMessage();
	        }
			System.out.println("a=>" + user.getId());
			System.out.println("b=>" + user.getUsername());
			System.out.println("c=>" + user.getPassword());
			System.out.println("d=>" + user.getName());
			System.out.println("d=>" + user.getName());
			int flag = userService.updateByPrimaryKeySelective(user);
			if(flag == 0){
				if(userService.insertSelective(user) != 0){
					return "success";
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
	@RequestMapping("/deleteUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.ADMIN)
	public String deleteUserById(@Valid String id){
		try{
			int flag = userService.deleteByPrimaryKey(id);
			userService.deleteRoleByUserId(id);
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
