package com.itzeng.ssm.domain;

import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.domain
 */

public class Role {
    private String id;
    private String roleName;
    private String roleDesc;

    private List<UserInfo> userInfos;

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
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
