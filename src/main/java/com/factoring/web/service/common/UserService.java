package com.factoring.web.service.common;

import java.util.List;
import java.util.Map;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.Role;
import com.factoring.web.model.User;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface UserService extends GenericService<User, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(User user);

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
    
    /**
     * 查询所有的user
     * @return
     */
    List<User> selectAllUser();
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);
    
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
    User selectByPrimaryKey(String id);
    
    //插入user_role表
    int insertRoleByUserId(List<Map> listdata);
    
    //获取所有用户角色
    List<Map> selectAllUserRole();
    
    //根据userid删除所属角色
    int deleteRoleByUserId(String id);
}
