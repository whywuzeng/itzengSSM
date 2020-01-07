package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.Permission;
import com.itzeng.ssm.service.IPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */

@Controller
@RequestMapping("/permission")
public class PremissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findByAll(){
        ModelAndView andView = new ModelAndView();
        List<Permission> permissionList = permissionService.findByAll();
        andView.addObject("permissionList",permissionList);
        andView.setViewName("permission-list");
        return andView;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
