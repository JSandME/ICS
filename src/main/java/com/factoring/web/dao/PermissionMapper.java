package com.factoring.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.Permission;
import com.factoring.web.model.PermissionExample;

/**
 * 权限 Dao 接口
 * 
 * @author 
 *   上午11:59:03
 **/
public interface PermissionMapper extends GenericDao<Permission, String> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
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
    
}