package com.factoring.web.service;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.Permission;
import com.factoring.web.model.Role;

/**
 * 权限 业务接口
 * 
 * @author 
 *   
 **/
public interface PermissionService extends GenericService<Permission, Long> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Long roleId);
    
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
    int deleteByPrimaryKey(Long id);
    
    /**
     * 
     * @param record
     * @return
     */
    Permission selectByPrimaryKey(Long id);

}
