package com.example.myfirstcms.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.pojo.DictDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictMapper extends BaseMapper<DictDO> {

    /**
     * 查询所有字典
     *
     * @return 字典类型集合
     */
    List<DictDO> selectAllDict();
}
