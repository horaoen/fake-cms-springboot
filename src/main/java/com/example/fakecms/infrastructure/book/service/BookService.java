package com.example.fakecms.infrastructure.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fakecms.infrastructure.book.entity.Book;

public interface BookService extends IService<Book> {

    boolean checkBookExistsByBookName(String title);
}
