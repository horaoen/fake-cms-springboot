package com.example.myfirstcms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myfirstcms.pojo.BookDO;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper  extends BaseMapper<BookDO> {
}
