package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.pojo.RoleDO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleMapper extends BaseMapper<RoleDO> {

    List<RoleDO> selectGroupsByUserId(Integer id);
}
