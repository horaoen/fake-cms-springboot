package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.PermissionMapper;
import com.example.myfirstcms.pojo.PermissionDO;
import com.example.myfirstcms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionDO> implements PermissionService {
    private PermissionService permissionService;

    @Autowired

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
}
