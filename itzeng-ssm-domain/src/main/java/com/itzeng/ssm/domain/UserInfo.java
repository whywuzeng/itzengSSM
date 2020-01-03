package com.itzeng.ssm.domain;

import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.domain
 */

public class UserInfo {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;
    private String statusStr;

    private List<Role> roles; // 多个角色
    private List<Permission> permissions; //多个权限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status!=null)
        {
            if (status == 0)
            {
                statusStr = "未开启";
            }else if (status == 1)
            {
                statusStr = "开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
