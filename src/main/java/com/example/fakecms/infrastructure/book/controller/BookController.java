package com.example.fakecms.infrastructure.book.controller;

import com.example.fakecms.autoconfigure.exception.ForbiddenException;
import com.example.fakecms.infrastructure.book.dto.BookDto;
import com.example.fakecms.infrastructure.book.entity.Book;
import com.example.fakecms.infrastructure.book.service.BookService;
import com.example.fakecms.infrastructure.dict.dto.DictDto;
import com.example.fakecms.infrastructure.dict.entity.Dict;
import com.example.fakecms.vo.UnifyResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Tag(name = "图书管理")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @Operation(summary = "书籍管理新增")
    public UnifyResponseVO addBook(@RequestBody BookDto bookDto) {
        if(StringUtils.hasText(bookDto.getTitle())){
            boolean exist = bookService.checkBookExistsByBookName(bookDto.getTitle());
            if(exist) throw new ForbiddenException(5007);
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        bookService.save(book);
        UnifyResponseVO<String> stringUnifyResponseVO = new UnifyResponseVO<>();
        stringUnifyResponseVO.setMessage("新增成功");
        return stringUnifyResponseVO;
    }
}
