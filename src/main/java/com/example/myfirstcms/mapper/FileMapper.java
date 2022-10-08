package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.pojo.FileDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper extends BaseMapper<FileDO> {

}
