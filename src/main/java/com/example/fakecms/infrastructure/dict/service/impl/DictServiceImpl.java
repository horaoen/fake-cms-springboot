package com.example.fakecms.infrastructure.dict.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fakecms.infrastructure.dict.dto.DictRequest;
import com.example.fakecms.infrastructure.dict.entity.Dict;

import com.example.fakecms.infrastructure.dict.entity.DictData;
import com.example.fakecms.infrastructure.dict.mapper.DictDataMapper;
import com.example.fakecms.infrastructure.dict.service.DictService;
import com.example.fakecms.infrastructure.dict.mapper.DictMapper;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private  DictMapper dictMapper;

    private DictDataMapper dictDataMapper;

    public DictServiceImpl(DictMapper dictMapper, DictDataMapper dictDataMapper) {
        this.dictMapper = dictMapper;
        this.dictDataMapper = dictDataMapper;
    }

    @Override
    public IPage<Dict> queryPage(DictRequest request) {
        IPage<Dict> page = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper
                .eq(StrUtil.isNotBlank(request.getDictCode()),
                        Dict::getDictCode,
                        request.getDictCode())
                .like(StrUtil.isNotBlank(request.getDictName()),
                        Dict::getDictName,
                        request.getDictCode());

        return super.page(page, queryWrapper);
    }

    @Override
    public boolean checkDictExistByDictCode(String dictCode) {
        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<Dict>();
        queryWrapper
                .eq(StrUtil.isNotBlank(dictCode),Dict::getDictCode, dictCode);
        Integer integer = dictMapper.selectCount(queryWrapper);
        return integer > 0;
    }

    @Override
    public String queryDictValueByKey(String code, String key) {
        LambdaQueryWrapper<DictData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StrUtil.isNotBlank(code), DictData::getDictCode, code)
                    .eq(StrUtil.isNotBlank(key), DictData::getDictKey, key);
        DictData dictData = dictDataMapper.selectOne(queryWrapper);
        return dictData.getDictValue();
    }

    @Override
    public boolean checkDictExistByDictId(String dictId) {
        LambdaQueryWrapper<Dict> lambdaQueryWrapper = new LambdaQueryWrapper<>();
       lambdaQueryWrapper
                .eq(StrUtil.isNotBlank(dictId),Dict::getId, dictId);
        Integer integer = dictMapper.selectCount(lambdaQueryWrapper);
        return integer > 0;
    }
}
