package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.Permission;
import com.itzeng.ssm.domain.Role;
import com.itzeng.ssm.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView andView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        andView.addObject("roleList",roleList);
        andView.setViewName("role-list");
        return andView;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String id){
        ModelAndView andView = new ModelAndView();
        //role
        Role role = roleService.findById(id);
        //permissionList
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(id);
        andView.addObject("role",role);
        andView.addObject("permissionList",permissionList);
        andView.setViewName("role-permission-add");
        return andView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,
                                      @RequestParam(name = "ids") String[] ids){

        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }
}
