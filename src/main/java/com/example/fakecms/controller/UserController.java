package com.example.fakecms.controller;


import com.example.fakecms.autoconfigure.exception.HttpException;
import com.example.fakecms.core.utils.JWTUtils;
import com.example.fakecms.dto.user.ChangePasswordDTO;
import com.example.fakecms.dto.user.LoginDTO;
import com.example.fakecms.dto.user.UpdateInfoDTO;
import com.example.fakecms.dto.user.UserDTO;
import com.example.fakecms.pojo.UserDO;
import com.example.fakecms.service.UserService;
import com.example.fakecms.vo.UnifyResponseVO;
import com.example.fakecms.vo.UpdatedVO;
import com.example.fakecms.vo.UserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
@Tag(name = "用户信息操作类")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * 用户登陆
     */
    @Operation(summary = "用户登录,返回token")
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
    @Operation(summary = "更新用户身份信息")
    @PutMapping("")
    public UpdatedVO update(@RequestBody @Validated UpdateInfoDTO updateInfoDTO){
        userService.updateUserInfo(updateInfoDTO);
        return new UpdatedVO(6);
    }

    @Operation(summary = "更新用户密码")
    @PutMapping("/change_password")
    public UpdatedVO updatePassword(@RequestBody @Validated ChangePasswordDTO validator) {
        userService.changeUserPassword(validator);
        return new UpdatedVO(4);
    }

    @Operation(summary = "根据id查询用户")
    @GetMapping("/{id}")
    public UnifyResponseVO<UserInfoVO> GetUserById(@PathVariable @Parameter(description = "用户id") Integer id){
        UserDO userDO = userService.queryById(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userDO, userInfoVO);
        UnifyResponseVO<UserInfoVO> unifyResponse = new UnifyResponseVO<>();
        unifyResponse.setMessage(userInfoVO);
        return unifyResponse;
    }
}
