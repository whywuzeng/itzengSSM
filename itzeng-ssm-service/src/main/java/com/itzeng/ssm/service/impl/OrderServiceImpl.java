package com.itzeng.ssm.service.impl;

import com.itzeng.ssm.dao.IOrderDao;
import com.itzeng.ssm.domain.Orders;
import com.itzeng.ssm.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service.impl
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {
        return orderDao.findAllByPage();
    }
}
