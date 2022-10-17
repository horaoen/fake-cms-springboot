package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.dto.admin.UpdateUserInfoDTO;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UpdateInfoDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.mapper.UserMapper;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDO getUserByUsername(String username) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserDO::getUsername, username);
        return this.getOne(wrapper);
    }

    @Override
    public UserDO login(LoginDTO loginDTO) {
       return userMapper.login(loginDTO);
    }

    @Override
    public UserDO updateUserInfo(UpdateInfoDTO updateInfoDTO) {
        return null;
    }

    @Override
    public UserDO queryById(int id) {
        return userMapper.queryById(id);
    }

}
