package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Permission;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface IPermissionDao {

    @Select("select * from permission, (select * from role_permission where roleId = #{roleId}) sfu where permission.id=sfu.permissionId")
    List<Permission> findDataByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findByAll();

    @Insert("insert into permission(permissionname, url)values(#{permissionName},#{url})")
    void save(Permission permission);
}
