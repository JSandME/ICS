package com.factoring.web.service.common;

import java.util.List;
import java.util.Map;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.Role;
import com.factoring.web.model.User;

/**
 * 角色 业务接口
 * 
 * @author 
 *   
 **/
public interface RoleService extends GenericService<Role, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Role role);
	
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(String userId);
    
    /**
     * 查询所有的Role
     * @return
     */
    List<Role> selectAllRole();
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);
    
    /**
     * 删除
     * @param record
     * @return
     */
    int deleteByPrimaryKey(String id);
    
    /**
     * 
     * @param record
     * @return
     */
    Role selectByPrimaryKey(String id);
    
    //插入role_permission表
    int insertPermissionsByRoleId(List<Map> listdata);
    
    //获取所有角色权限
    List<Map> selectAllRolePermission();
    
  //根据roleid删除权限
    int deletePermissionByRoleId(String id);
}
