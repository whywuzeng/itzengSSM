package com.itzeng.ssm.service.impl;

import com.itzeng.ssm.dao.IUserDao;
import com.itzeng.ssm.domain.Role;
import com.itzeng.ssm.domain.UserInfo;
import com.itzeng.ssm.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/4.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service.impl
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据名字查找 userinfo
        UserInfo userInfo = userDao.findByUsername(username);
        //然后才得到角色
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authority = getAuthority(roles);

        User user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, authority);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (roles!=null)
        {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        return authorities;
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findByUserId(id);
    }

    @Override
    public List<UserInfo> findByAllData() throws Exception {

        return userDao.findByAllData();
    }

    @Override
    public void save(UserInfo info) throws Exception {
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        userDao.save(info);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) {

        return userDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            userDao.addRoleToUser(userId,id);
        }
    }
}
