package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.UserMapper;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.UserService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {


}
