package com.example.myfirstcms.infrastructure.dict.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myfirstcms.infrastructure.dict.dto.DictRequest;
import com.example.myfirstcms.infrastructure.dict.entity.Dict;

public interface DictService extends IService<Dict> {
    IPage<Dict> queryPage(DictRequest request);

    boolean checkDictExistByDictCode(String dictCode);
}
