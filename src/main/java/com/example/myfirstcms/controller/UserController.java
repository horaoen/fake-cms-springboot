package com.example.myfirstcms.controller;


import com.example.myfirstcms.Token.JWTUtils;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/login")
//    public Map<String,Object> UserLogin(UserDO userDO){
//        Map<String,Object> result = new HashMap<>();
//        try {
//            UserDO user = userService.UserLogin(userDO);
//            Map<String, String> map = new HashMap<>();//用来存放payload
//            map.put("id", String.valueOf(user.getId()));
//            map.put("username", user.getUsername());
//            String token = JWTUtils.getToken(map);
//            result.put("state",true);
//            result.put("msg","登录成功!!!");
//            result.put("token",token); //成功返回token信息
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("state","false");
//            result.put("msg",e.getMessage());
//        }
//        return result;
//    }

}
