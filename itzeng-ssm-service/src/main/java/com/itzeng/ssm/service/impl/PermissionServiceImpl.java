package com.itzeng.ssm.service.impl;

import com.itzeng.ssm.dao.IPermissionDao;
import com.itzeng.ssm.domain.Permission;
import com.itzeng.ssm.service.IPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service.impl
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findByAll() {
        return permissionDao.findByAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
