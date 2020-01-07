package com.itzeng.ssm.controller;

import com.itzeng.ssm.domain.Product;
import com.itzeng.ssm.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;

/**
 * Created by Administrator on 2019/12/31.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //2020-01-11 10:50
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }

    @Autowired
    private IProductService productService;

    //只能admin可以看
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(){
        ModelAndView view = new ModelAndView();
        List<Product> products = productService.findAll();
        view.addObject("productList",products);
        view.setViewName("product-list");
        return view;
    }

    @RequestMapping("/save.do")
    public String save(Product product)throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
