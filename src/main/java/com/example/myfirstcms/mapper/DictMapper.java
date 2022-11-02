package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.infrastructure.dict.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {
    int checkDictExistByDictCode(String dictCode);

    String queryDictValueByKey(@Param("dict_code")String code, @Param("dict_key")String key);
}

