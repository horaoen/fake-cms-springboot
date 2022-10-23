package com.example.myfirstcms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myfirstcms.dto.admin.UpdateUserInfoDTO;
import com.example.myfirstcms.dto.user.ChangePasswordDTO;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UpdateInfoDTO;
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

    UserDO login(LoginDTO loginDTO);

    UserDO updateUserInfo(UpdateInfoDTO updateInfoDTO);

    UserDO queryById(int id);

    UserDO changeUserPassword(ChangePasswordDTO validator);
}
