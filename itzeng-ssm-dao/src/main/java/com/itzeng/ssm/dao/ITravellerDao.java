package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Traveller;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/1/3.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface ITravellerDao {
//    @Select("select * from order_traveller where orderId =#{orderId}")
//    @Results({
//            @Result(column = "travellerId",one = @One(select = "com.itzeng.ssm.dao.ITravellerDao.findByTravellerId"))
//    })
//    List<Traveller> findByOrderId(String orderId);
//
//    @Select("select * from traveller where id = #{tarvellerId}")
//    Traveller findByTravellerId(String tarvellerId);

    @Select("select * from traveller,(select * from order_traveller where orderId =#{orderId}) tra where id =tra.travellerid")
    List<Traveller> findByOrderId(String orderId);
}
