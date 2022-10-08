package com.example.myfirstcms.controller;


import com.example.myfirstcms.pojo.BookDO;
import com.example.myfirstcms.service.BookService;
import com.example.myfirstcms.service.Impl.BookServiceImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("")
    public List<BookDO> getBooks() {
        List<BookDO> books = bookServiceImpl.list();
        return books;
    }
}
