package com.factoring.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.Permission;
import com.factoring.web.model.PermissionExample;
import com.factoring.web.model.Role;

/**
 * 权限 Dao 接口
 * 
 * @author 
 *   上午11:59:03
 **/
public interface PermissionMapper extends GenericDao<Permission, Long> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long id);

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
    List<Permission> selectPermissionsByRoleId(Long roleId);
    
    /**
     * 查询所有的
     * @return
     */
    List<Permission> selectAllPermission();
}