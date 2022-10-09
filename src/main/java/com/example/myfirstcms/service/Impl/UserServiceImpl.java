package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.UserMapper;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDO UserLogin(UserDO userDO) {
        UserDO userDO1 = userMapper.UserLogin(userDO);
        if(userDO!=null){
            return userDO;
        }
        throw  new RuntimeException("登录失败~~");
    }
}
