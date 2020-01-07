package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.SysLog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface ISysLogDao {
    @Insert("insert into sysLog(Visittime, Username, Ip, Url, Executiontime, Method)values(#{visitime},#{name},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from syslog")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "visitTime",property = "visitime"),
            @Result(column = "username",property = "name"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "executionTime",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    List<SysLog> findAll();
}
