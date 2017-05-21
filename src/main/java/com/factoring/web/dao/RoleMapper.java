package com.factoring.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.Role;
import com.factoring.web.model.RoleExample;

/**
 * 角色Dao 接口
 * 
 * @author 
 *   上午11:55:59
 **/
public interface RoleMapper extends GenericDao<Role, String> {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param id
     * @return
     */
    List<Role> selectRolesByUserId(String userId);
    
    /**
     * 查询所有的Role
     * @return
     */
    List<Role> selectAllRole();
    
    //插入role_permission表
    int insertPermissionsByRoleId(List<Map> listdata);
}