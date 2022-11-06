package com.example.fakecms.infrastructure.dict.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fakecms.infrastructure.dict.dto.DictRequest;
import com.example.fakecms.infrastructure.dict.entity.Dict;

public interface DictService extends IService<Dict> {
    IPage<Dict> queryPage(DictRequest request);

    boolean checkDictExistByDictCode(String dictCode);

    String queryDictValueByKey(String code, String key);

    boolean checkDictExistByDictId(String dictId);
}
