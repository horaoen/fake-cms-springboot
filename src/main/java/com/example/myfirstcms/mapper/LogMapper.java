package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myfirstcms.pojo.LogDO;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface LogMapper extends BaseMapper<LogDO> {

}
