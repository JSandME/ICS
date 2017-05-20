package com.factoring.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.RoleMapper;
import com.factoring.web.model.Role;
import com.factoring.web.service.RoleService;

/**
 * 角色Service实现类
 *
 * @author 
 *   
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, Long> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

	@Override
	public List<Role> selectAllRole() {
		return roleMapper.selectAllRole();
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role selectByPrimaryKey(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

}
