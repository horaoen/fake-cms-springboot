package com.example.myfirstcms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myfirstcms.pojo.RoleDO;

import java.util.List;


public interface RoleService extends IService<RoleDO> {


    List<RoleDO> getUserGroupsByUserId(Integer id);
}
