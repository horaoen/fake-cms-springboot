package com.example.fakecms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fakecms.dto.user.LoginDTO;
import com.example.fakecms.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    UserDO login(LoginDTO loginDTO);

    UserDO queryById(int id);

    int selectCountByUsername(String username);

    int updateByUserInfo(UserDO userDO);
}

