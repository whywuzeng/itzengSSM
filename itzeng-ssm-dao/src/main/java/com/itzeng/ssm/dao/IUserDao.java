package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.UserInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/1/4.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(select = "com.itzeng.ssm.dao.IRoleDao.findByUserInfoId")),
    })
    UserInfo findByUsername(String username);

    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "com.itzeng.ssm.dao.IRoleDao.findByUserInfoId")),
    })
    UserInfo findByUserId(Long userId);

    @Select("select * from users")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
    })
    List<UserInfo> findByAllData();

    @Insert("insert into users(email, username, password, phonenum, status) values(#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    void save(UserInfo info) throws Exception;
}
