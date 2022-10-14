package com.example.myfirstcms.controller;


import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.utils.JWTUtils;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO
//                        @RequestHeader(value = "Tag", required = false) String tag
    ){
        HashMap<String, Object> hashMap = new HashMap<>();
        //验证码逻辑
//        UserDO user = userService.getUserByUsername(loginDTO.getUsername());
//        if(user == null){
//            throw new NotFoundException(10021);
//        }

        UserDTO login = userService.login(loginDTO);
        if(login == null){
            throw new HttpException(10031);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", login.getUsername());
        map.put("nickname", login.getNickname());
        map.put("avatar", login.getAvatar());
        map.put("email", login.getEmail());
        String token = JWTUtils.getToken(map);
        return token;
    }

}
