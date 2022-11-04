package com.example.fakecms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fakecms.pojo.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

}
