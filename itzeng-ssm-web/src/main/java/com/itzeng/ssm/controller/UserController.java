package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.Role;
import com.itzeng.ssm.domain.UserInfo;
import com.itzeng.ssm.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ModelAndView findById(@RequestParam(required = true,name = "id") String id)
    {
        ModelAndView andView = new ModelAndView();
        UserInfo user = userService.findById(id);
        andView.addObject("user",user);
        andView.setViewName("user-show");
        return andView;
    }

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAllData() throws Exception {
        ModelAndView andView = new ModelAndView();
        List<UserInfo> userList = userService.findByAllData();
        andView.setViewName("user-list");
        andView.addObject("userList",userList);
        return andView;
    }

    //在方法调用之前,基于表达式的计算结果来限制对方法的访问
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == 'tom'")
    public String saveData(UserInfo info) throws Exception{
        userService.save(info);
        return "redirect:findAll.do";
    }

    //查出用户能够添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id") String id) throws Exception{
        ModelAndView andView = new ModelAndView();
        List<Role> roleList = userService.findUserByIdAndAllRole(id);
        UserInfo user = userService.findById(id);
        andView.addObject("user",user);
        andView.addObject("roleList",roleList);
        andView.setViewName("user-role-add");
        return andView;
    }

//    添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") String userId,@RequestParam(name = "ids") String[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }

}
