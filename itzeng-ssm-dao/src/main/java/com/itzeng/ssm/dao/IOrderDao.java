package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Orders;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface IOrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peoplecount",property = "peoplecount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productId",property = "product",one =@One(select = "com.itzeng.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAllByPage() throws Exception;

    //查看orders 详情
    @Select("Select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peoplecount",property = "peoplecount"),
            @Result(column = "productId",property = "product",one = @One(select = "com.itzeng.ssm.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select ="com.itzeng.ssm.dao.ITravellerDao.findByOrderId" )),
            @Result(column = "memberId",property = "member",one = @One(select = "com.itzeng.ssm.dao.IMemberDao.findByMemberId")),
            @Result(column = "payType",property = "payType"),
    })
    Orders findById(String orderId);
}
