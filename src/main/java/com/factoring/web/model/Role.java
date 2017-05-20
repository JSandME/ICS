package com.factoring.web.model;

import javax.validation.constraints.NotNull;

/**
 * 角色模型
 * 
 * @author 
 *   
 **/
public class Role {
    private Long id;

    @NotNull
    private String roleName;

    @NotNull
    private String roleSign;

    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Role [id=" + id + ", roleName=" + roleName + ", roleSign=" + roleSign + ", description=" + description + "]";
    }

}