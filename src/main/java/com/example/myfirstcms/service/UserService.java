package com.example.myfirstcms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myfirstcms.pojo.UserDO;
import org.apache.catalina.User;


import java.util.List;
import java.util.Map;


public interface UserService extends IService<UserDO> {

    UserDO UserLogin(UserDO userDO);
}
