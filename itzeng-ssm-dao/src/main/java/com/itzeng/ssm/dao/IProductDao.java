package com.itzeng.ssm.dao;

import com.itzeng.ssm.domain.Product;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.dao
 */

public interface IProductDao {
    @Select("Select * from product")
    List<Product> findAll();

    @Insert("insert into product(productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{productId}")
    Product findById(String productId) throws Exception;
}
