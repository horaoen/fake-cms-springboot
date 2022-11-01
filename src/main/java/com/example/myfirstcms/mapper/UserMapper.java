package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.dto.user.LoginDTO;
import com.example.myfirstcms.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    UserDO login(LoginDTO loginDTO);

    UserDO queryById(int id);

    int selectCountByUsername(String username);

    int updateByUserInfo(UserDO userDO);
}

