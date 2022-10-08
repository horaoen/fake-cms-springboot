package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.BookMapper;
import com.example.myfirstcms.mapper.GroupMapper;
import com.example.myfirstcms.pojo.BookDO;
import com.example.myfirstcms.pojo.GroupDO;
import com.example.myfirstcms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO>  implements BookService {

}
