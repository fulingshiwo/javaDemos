package com.mongodb.controller;
import com.mongodb.entity.Product;
import com.mongodb.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ChenQuan on 2016/12/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Resource
    private ProductService productService;

    @RequestMapping("/savePro")
    @ResponseBody
    public String  savePro(){
        LOGGER.info("mongo添加产品");
        //添加产品
        Product addProduct=new Product();
        addProduct.setSproName("新增产品名称");
        productService.saveProduct(addProduct);
        return "新增产品名称";
    }


    @RequestMapping("/showInfo")
    public String showUserInfo(){
        LOGGER.info("查询用户");
        return "/user/showInfo";
    }

}
