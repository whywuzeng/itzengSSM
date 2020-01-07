package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.SysLog;
import com.itzeng.ssm.service.ISysLogService;

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
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService logService;

    @RequestMapping("/findAll.do")
    public ModelAndView findByAll(){
        ModelAndView andView = new ModelAndView();
        List<SysLog> sysLogs = logService.findAll();
        andView.addObject("sysLogs",sysLogs);
        andView.setViewName("syslog-list");
        return andView;
    }
}
