package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.Orders;
import com.itzeng.ssm.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView findAllByPage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                      @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer pageSize) throws Exception{
        ModelAndView view = new ModelAndView();
        List<Orders> ordersList = orderService.findAllByPage(page, pageSize);
        view.addObject("ordersList",ordersList);
        view.setViewName("orders-list");
        return view;
    }
}
