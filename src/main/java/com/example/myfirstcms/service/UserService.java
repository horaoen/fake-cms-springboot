package com.example.myfirstcms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.pojo.UserDO;


public interface UserService extends IService<UserDO> {

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserDO getUserByUsername(String username);

    UserDTO login(LoginDTO loginDTO);
}
