package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.dto.user.UserDTO;
import com.example.myfirstcms.pojo.UserDO;
import org.springframework.stereotype.Repository;



@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    UserDO login(LoginDTO loginDTO);

    UserDO queryById(int id);
}
