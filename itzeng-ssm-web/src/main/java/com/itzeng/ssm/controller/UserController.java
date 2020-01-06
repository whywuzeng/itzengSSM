package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.UserInfo;
import com.itzeng.ssm.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2020/1/4.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(required = true,name = "id") Long id)
    {
        ModelAndView andView = new ModelAndView();
        UserInfo user = userService.findById(id);
        andView.addObject("user",user);
        andView.setViewName("user-show");
        return andView;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAllData() throws Exception {
        ModelAndView andView = new ModelAndView();
        List<UserInfo> userList = userService.findByAllData();
        andView.setViewName("user-list");
        andView.addObject("userList",userList);
        return andView;
    }


    @RequestMapping("/save.do")
    public String saveData(UserInfo info) throws Exception{
        userService.save(info);
        return "redirect:findAll.do";
    }

}
