package com.example.myfirstcms.infrastructure.dict.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.infrastructure.dict.dto.DictRequest;
import com.example.myfirstcms.infrastructure.dict.entity.Dict;

import com.example.myfirstcms.infrastructure.dict.service.DictService;
import com.example.myfirstcms.infrastructure.dict.mapper.DictMapper;
import org.springframework.stereotype.Service;


@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private final DictMapper dictMapper;

    public DictServiceImpl(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
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
        int rows = this.baseMapper.checkDictExistByDictCode(dictCode);
        return rows > 0;
    }
}
