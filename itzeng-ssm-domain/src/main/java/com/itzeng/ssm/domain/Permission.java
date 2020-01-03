package com.itzeng.ssm.domain;

import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.domain
 */

public class Permission {
    private String id;
    private String permissionName;
    private String url;

    List<UserInfo> userInfos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
