package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Role;

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

public interface IRoleDao {
    @Select("select * from role, (select * from users_role USERSID = #{userInfoId}) sfu where role.id=sfu.ROLEID")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many = @Many(select = "com.itzeng.ssm.dao.IPermissionDao.findDataByRoleId"))
    })
    List<Role> findByUserInfoId(String userInfoId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role( rolename, roledesc) values( #{rolename}, #{roledesc})")
    void save(Role role);
}
