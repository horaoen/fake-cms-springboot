package com.example.fakecms.infrastructure.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fakecms.infrastructure.dict.entity.DictData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictDataMapper extends BaseMapper<DictData> {
}
