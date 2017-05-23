package com.factoring.web.security;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色标识配置类, <br>
 * 与 role_info 角色表中的 role_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresRoles(value = RoleSign.ADMIN)
 * public String admin() {
 *     return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 * @author 
 *   
 **/
public class RoleSign {

    /**
     * 普通后台管理员 标识
     */
    public static final String ADMIN = "admin";

    /**
     * 保理商 标识
     */
    public static final String FACTOR = "factor";

    /**
     * 核心企业 标识
     */
    public static final String CORE_COMPANY = "core_company";

    /**
     * 下游企业 标识
     */
    public static final String DOWNSTREAM_FIRMS = "downstream_firms";

    /**
     * 添加更多...
     */
    
    
    /**
     * 获取成员常量
     */
    public static final List<Map> getClassFields(){
    	
    	List<Map> list = new ArrayList<Map>();
    	try {
    		Class c=(new RoleSign()).getClass();
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
