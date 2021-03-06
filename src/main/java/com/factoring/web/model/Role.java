package com.factoring.web.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 角色模型
 * 
 * @author 
 *   
 **/
public class Role {
    private String  id;

    @NotNull
    private String roleName;

    @NotNull
    private String roleSign;

    @NotNull
    private String description;
    
    private List permissions;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign == null ? null : roleSign.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public List getpermissions() {
		return permissions;
	}

	public void setpermissions(List permissions) {
		this.permissions = permissions;
	}

	@Override
    public String toString() {
        return "Role [id=" + id + ", roleName=" + roleName + ", roleSign=" + roleSign + ", description=" + description + "]";
    }

}