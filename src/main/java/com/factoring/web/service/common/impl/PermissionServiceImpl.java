package com.factoring.web.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.PermissionMapper;
import com.factoring.web.model.Permission;
import com.factoring.web.service.common.PermissionService;

/**
 * 权限Service实现类
 *
 * @author 
 *   
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, String> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public GenericDao<Permission, String> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(String roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }

	@Override
	public List<Permission> selectAllPermission() {
		return permissionMapper.selectAllPermission();
	}

	@Override
	public int updateByPrimaryKeySelective(Permission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Permission selectByPrimaryKey(String id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Permission permission) {
		return permissionMapper.insertSelective(permission);
	}

}
