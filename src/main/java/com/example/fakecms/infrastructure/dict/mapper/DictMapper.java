package com.example.fakecms.infrastructure.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fakecms.infrastructure.dict.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {

}

