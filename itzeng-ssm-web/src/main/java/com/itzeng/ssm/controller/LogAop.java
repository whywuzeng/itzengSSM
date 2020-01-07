package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.SysLog;
import com.itzeng.ssm.service.ISysLogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */
@Component
@Aspect
public class LogAop {

    private Date startTime; // 访问时间
    private Class<?> executionClass;
    private Method executionMethod;

    @Autowired
    private ISysLogService logService;

    @Autowired
    private HttpServletRequest request;

    @Before("execution(* com.itzeng.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp)throws NoSuchMethodException, SecurityException{
        startTime = new Date();
        //获取方法类
        executionClass = jp.getTarget().getClass();

        String methodName = jp.getSignature().getName();

        Object[] args = jp.getArgs();
        if (args==null || args.length==0)
        {
            //无参方法
            executionMethod = executionClass.getMethod(methodName);
        }else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < classes.length; i++) {
                classes[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName,classes);
        }
    }

    @After("execution(* com.itzeng.ssm.controller.*.*(..))")
    public void doAfter()throws Exception{
        long time = new Date().getTime() - startTime.getTime();

        String url = ""; // 链接
        if (executionClass!=null && executionMethod!=null&& executionClass!=LogAop.class)
        {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null)
            {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null)
                {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0]+methodValue[0];

                    //获取ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setIp(ip);
                    sysLog.setExecutionTime(time);
                    sysLog.setMethod("[类名]"+executionClass.getName()+"[方法名]"+executionMethod.getName());
                    sysLog.setName(username);
                    sysLog.setUrl(url);
                    sysLog.setVisitime(startTime);

                    logService.save(sysLog);
                }
            }
        }
    }
}
