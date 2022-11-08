package com.example.fakecms.infrastructure.book.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fakecms.infrastructure.book.entity.Book;
import com.example.fakecms.infrastructure.book.mapper.BookMapper;
import com.example.fakecms.infrastructure.book.service.BookService;
import com.example.fakecms.infrastructure.dict.entity.Dict;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    private BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean checkBookExistsByBookName(String title) {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StrUtil.isNotBlank(title),Book::getTitle, title);
        Integer integer = bookMapper.selectCount(queryWrapper);
        return integer > 0;
    }
}
