package com.nd.springmvc.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by ChenQuan on 2016/12/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);


    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable String userId){
        LOGGER.info("查询用户：" + userId);

        return "/user/showInfo";
    }

}
