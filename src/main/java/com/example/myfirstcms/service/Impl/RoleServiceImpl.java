package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.RoleMapper;
import com.example.myfirstcms.pojo.RoleDO;
import com.example.myfirstcms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements RoleService {


    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDO> getUserGroupsByUserId(Integer id) {
        return this.baseMapper.selectGroupsByUserId(id);
    }
}
