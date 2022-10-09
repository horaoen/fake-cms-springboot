package com.example.myfirstcms.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.pojo.BookDO;
import com.example.myfirstcms.pojo.DictDataDO;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDataMapper  extends BaseMapper<DictDataDO> {
}
