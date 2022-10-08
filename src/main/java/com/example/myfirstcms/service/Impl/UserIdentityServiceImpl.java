package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.UserIdentityMapper;
import com.example.myfirstcms.pojo.UserIdentityDO;
import com.example.myfirstcms.service.UserIdentityService;
import org.springframework.stereotype.Service;


@Service
public class UserIdentityServiceImpl extends ServiceImpl<UserIdentityMapper, UserIdentityDO> implements UserIdentityService {



}
