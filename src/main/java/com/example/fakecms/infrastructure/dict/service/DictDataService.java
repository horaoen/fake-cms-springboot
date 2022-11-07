package com.example.fakecms.infrastructure.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fakecms.infrastructure.dict.entity.DictData;

public interface DictDataService extends IService<DictData> {
    Boolean checkExistByCodeAndKey(String dictCode, String dictKey);
}
