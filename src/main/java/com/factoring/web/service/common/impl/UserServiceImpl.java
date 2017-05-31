package com.factoring.web.service.common.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.UserMapper;
import com.factoring.web.model.User;
import com.factoring.web.model.UserExample;
import com.factoring.web.service.common.UserService;

/**
 * 用户Service实现类
 *
 * @author 
 *   上午11:54:24
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<User, String> getDao() {
        return userMapper;
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        return list.get(0);
    }

	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertRoleByUserId(List<Map> listdata) {
		return userMapper.insertRoleByUserId(listdata);
	}

	@Override
	public List<Map> selectAllUserRole() {
		return userMapper.selectAllUserRole();
	}

	@Override
	public int deleteRoleByUserId(String id) {
		return userMapper.deleteRoleByUserId(id);
	}

	@Override
	public int insertSelective(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public User selectByUserName(String username) {
		return userMapper.selectByUserName(username);
	}
	

}
