package com.example.myfirstcms.infrastructure.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.infrastructure.dict.entity.DictData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictDataMapper extends BaseMapper<DictData> {
}
