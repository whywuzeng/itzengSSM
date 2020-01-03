package com.itzeng.ssm.service;

import com.itzeng.ssm.domain.Orders;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service
 */

public interface IOrderService {
    List<Orders> findAllByPage(int page, int pageSize) throws Exception;

    Orders findById(String orderId) throws Exception;
}
