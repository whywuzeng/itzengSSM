package com.itzeng.ssm.service;

import com.itzeng.ssm.domain.Role;

import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service
 */

public interface IRoleService {

    List<Role> findAll();

    void save(Role role);
}
