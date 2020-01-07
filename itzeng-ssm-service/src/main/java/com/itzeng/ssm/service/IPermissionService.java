package com.itzeng.ssm.service;

import com.itzeng.ssm.domain.Permission;

import java.util.List;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service
 */

public interface IPermissionService {

    List<Permission> findByAll();

    void save(Permission permission);
}
