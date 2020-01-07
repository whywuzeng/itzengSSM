package com.itzeng.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itzeng.ssm.domain.Orders;
import com.itzeng.ssm.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAllByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                      @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception{
        ModelAndView view = new ModelAndView();
        List<Orders> ordersList = orderService.findAllByPage(page, pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        view.addObject("pageInfo",pageInfo);
        view.setViewName("orders-page-list");
        return view;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
        ModelAndView view = new ModelAndView();
        Orders order = orderService.findById(orderId);
        view.setViewName("orders-show");
        view.addObject("orders",order);
        return view;
    }
}
