package com.example.fakecms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fakecms.dto.user.ChangePasswordDTO;
import com.example.fakecms.dto.user.LoginDTO;
import com.example.fakecms.dto.user.UpdateInfoDTO;
import com.example.fakecms.pojo.UserDO;


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
