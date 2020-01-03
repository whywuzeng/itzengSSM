package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Member;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2020/1/3.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface IMemberDao {

    @Select("select * from member where id =#{memberId}")
    Member findByMemberId(String memberId);
}
