package com.example.myfirstcms.controller;


import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.utils.JWTUtils;
import com.example.myfirstcms.dto.user.ChangePasswordDTO;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UpdateInfoDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import com.example.myfirstcms.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * 用户登陆
     */
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

        UserDO login = userService.login(loginDTO);
        UserDTO userDTO = new UserDTO();
        if(login == null){
            throw new HttpException(10031);
        }
        BeanUtils.copyProperties(login, userDTO);
        System.out.println(userDTO);
        Map<String, String> map = new HashMap<String,String>();
        map.put("id", userDTO.getId().toString());
        map.put("username", userDTO.getUsername());
        map.put("nickname", userDTO.getNickname());
        map.put("avatar", userDTO.getAvatar());
        map.put("email", userDTO.getEmail());
        String token = JWTUtils.getToken(map);
        return token;
    }

    /**
     * 更新用户信息
     */
    @PutMapping("")
    public UpdatedVO update(@RequestBody @Validated UpdateInfoDTO updateInfoDTO){
        userService.updateUserInfo(updateInfoDTO);
        return new UpdatedVO(6);
    }

    @PutMapping("/change_password")
    public UpdatedVO updatePassword(@RequestBody @Validated ChangePasswordDTO validator) {
        userService.changeUserPassword(validator);
        return new UpdatedVO(4);
    }
}
