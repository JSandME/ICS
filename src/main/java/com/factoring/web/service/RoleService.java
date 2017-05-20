package com.factoring.web.service;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.Role;

/**
 * 角色 业务接口
 * 
 * @author 
 *   
 **/
public interface RoleService extends GenericService<Role, Long> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Long userId);
    
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
    int deleteByPrimaryKey(Long id);
    
    /**
     * 
     * @param record
     * @return
     */
    Role selectByPrimaryKey(Long id);
    
}
