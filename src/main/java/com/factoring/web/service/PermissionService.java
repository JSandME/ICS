package com.factoring.web.service;

import java.util.List;
import java.util.Map;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.Permission;
import com.factoring.web.model.Role;
import com.factoring.web.model.User;

/**
 * 权限 业务接口
 * 
 * @author 
 *   
 **/
public interface PermissionService extends GenericService<Permission, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Permission permission);

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(String roleId);
    
    /**
     * 查询所有的
     * @return
     */
    List<Permission> selectAllPermission();
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Permission record);
    
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
    Permission selectByPrimaryKey(String id);

}
