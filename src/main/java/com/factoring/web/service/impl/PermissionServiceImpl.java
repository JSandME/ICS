package com.factoring.web.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.PermissionMapper;
import com.factoring.web.model.Permission;
import com.factoring.web.model.Role;
import com.factoring.web.service.PermissionService;

/**
 * 权限Service实现类
 *
 * @author 
 *   
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public GenericDao<Permission, Long> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Long roleId) {
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
	public int deleteByPrimaryKey(Long id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Permission selectByPrimaryKey(Long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}
}
