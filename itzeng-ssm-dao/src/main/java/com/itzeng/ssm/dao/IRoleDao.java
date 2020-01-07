package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Permission;
import com.itzeng.ssm.domain.Role;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
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
    @Select("select * from role, (select * from users_role where USERSID = #{userInfoId}) sfu where role.id=sfu.ROLEID")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many = @Many(select = "com.itzeng.ssm.dao.IPermissionDao.findDataByRoleId"))
    })
    List<Role> findByUserInfoId(String userInfoId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role( rolename, roledesc) values( #{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    Role findById(String id);

    @Select("select * from permission where permission.id not in(select permissionId from role_permission where roleid = #{id})")
    List<Permission> findRoleByIdAndAllPermission(String id);

    @Insert("insert into role_permission(roleId,permissionId)values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
