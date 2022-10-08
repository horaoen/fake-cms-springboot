package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myfirstcms.pojo.UserDO;
import org.springframework.stereotype.Repository;



@Repository
public interface UserMapper extends BaseMapper<UserDO> {

}