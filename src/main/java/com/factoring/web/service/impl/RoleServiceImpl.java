package com.factoring.web.service.impl;

import java.util.List;
import java.util.Map;

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
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, String> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(String userId) {
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
	public int deleteByPrimaryKey(String id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role selectByPrimaryKey(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertPermissionsByRoleId(List<Map> listdata) {
		return roleMapper.insertPermissionsByRoleId(listdata);
	}

	@Override
	public List<Map> selectAllRolePermission() {
		return roleMapper.selectAllRolePermission();
	}

	@Override
	public int deleteByRoleId(String id) {
		return roleMapper.deleteByRoleId(id);
	}

}
