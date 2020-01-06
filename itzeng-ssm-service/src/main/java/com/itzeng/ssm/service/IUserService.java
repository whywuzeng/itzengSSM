package com.itzeng.ssm.service;

import com.itzeng.ssm.domain.UserInfo;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Administrator on 2020/1/4.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service
 */

public interface IUserService extends UserDetailsService {

    UserInfo findById(Long id);

    List<UserInfo> findByAllData() throws Exception;

    void save(UserInfo info) throws Exception;
}
