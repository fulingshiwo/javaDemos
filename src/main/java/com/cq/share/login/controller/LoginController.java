package com.cq.share.login.controller;

import com.cq.common.entity.DataResult;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChenQuan on 2017/3/8.
 */
@RestController
@RequestMapping({"/share/login/loginApi"})
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping("/showInfo")
    public DataResult<Map<String,Object>> showUserInfo() {
        LOGGER.info("查询用户");
        Map<String,Object> map=new HashMap<>();
        map.put("user","1212");
        DataResult<Map<String,Object>> result=new DataResult(1,map,"success");
        return result;
    }
}
