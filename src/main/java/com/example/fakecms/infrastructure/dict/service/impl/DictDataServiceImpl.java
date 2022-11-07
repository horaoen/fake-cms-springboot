package com.example.fakecms.infrastructure.dict.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fakecms.infrastructure.dict.entity.DictData;
import com.example.fakecms.infrastructure.dict.mapper.DictDataMapper;
import com.example.fakecms.infrastructure.dict.mapper.DictMapper;
import com.example.fakecms.infrastructure.dict.service.DictDataService;
import org.springframework.stereotype.Service;

@Service
public class DictDataServiceImpl  extends ServiceImpl<DictDataMapper, DictData> implements DictDataService {

    private DictDataMapper dictDataMapper;

    public DictDataServiceImpl(DictDataMapper dictDataMapper) {
        this.dictDataMapper = dictDataMapper;
    }

    @Override
    public Boolean checkExistByCodeAndKey(String dictCode, String dictKey) {
        LambdaQueryWrapper<DictData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .eq(StrUtil.isNotBlank(dictCode), DictData::getDictCode, dictCode)
                .eq(StrUtil.isNotBlank(dictKey), DictData::getDictKey, dictKey);

        Integer integer = dictDataMapper.selectCount(lambdaQueryWrapper);

        return integer > 0;
    }
}
