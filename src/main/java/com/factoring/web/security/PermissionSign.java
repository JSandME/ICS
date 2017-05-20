package com.factoring.web.security;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 *     return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 * 
 * @author 
 *   
 **/
public class PermissionSign {
	
	/**
     * 管理员权限
     */
    public static final String USER_SUPER_ADMIN = "super_admin";

    /**
     * 用户新增权限 标识
     */
    public static final String USER_CREATE = "user:create";
    
    /**
     * 用户新增权限 标识
     */
    public static final String USER_SELECT = "user:select";

    /**
     * 用户删除权限 标识
     */
    public static final String USER_DELETE = "user:delete";
    
    /**
     * 用户更新权限 标识
     */
    public static final String USER_UPDATE = "user:update";

    /**
     * 添加更多...
     */

    /**
     * 获取成员常量
     */
    public static final List<Map> getClassFields(){
    	
    	List<Map> list = new ArrayList<Map>();
    	try {
    		Class c=(new PermissionSign()).getClass();
    		Field[] declaredFields = c.getDeclaredFields();
    		for (Field field : declaredFields) {
	            if (null != field) {
	                Object object = field.get(null);
	                if (null != object) {
	                	Map<String, String> map = new HashMap<String, String>();
	                	map.put("key", object.toString());
	                	list.add(map);
	                }
	            }
	            
    		}
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
    	return list;
	}
}
