package com.factoring.web.controller.factor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.factoring.web.controller.admin.AdminRoleController;

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

    @RequestMapping("/page")
    public String login() {
        return "product";
    }

	/*@RequestMapping(value = "/getDate", produces="application/json; charset=utf-8")
	@ResponseBody
	@RequiresRoles(value= RoleSign.FACTOR )
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
	
	*//**
	 * user页面获取类
	 * @return
	 *//*
	@RequestMapping("/getUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.FACTOR)
	public User getUserbyId(String id)
	{
		User user = userService.selectByPrimaryKey(id);
		return user;
	}
	
	
	*//**
	 * 
	 * @param role
	 * @param result
	 * @param model
	 * @return
	 *//*
	@RequestMapping("/updateUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.FACTOR)
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
			int flag = userService.updateByPrimaryKeySelective(user);
			if(flag == 0){
				if(userService.insertSelective(user) != 0){
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
	
	*//**
	 * 
	 * @return
	 *//*
	@RequestMapping("/deleteUser")
	@ResponseBody
	@RequiresRoles(value= RoleSign.FACTOR)
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
	}*/

}