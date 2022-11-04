package com.example.fakecms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fakecms.mapper.RoleMapper;
import com.example.fakecms.pojo.RoleDO;
import com.example.fakecms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements RoleService {


    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
