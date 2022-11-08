package com.example.fakecms.infrastructure.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.fakecms.autoconfigure.exception.ForbiddenException;
import com.example.fakecms.autoconfigure.exception.NotFoundException;
import com.example.fakecms.infrastructure.book.dto.BookDto;
import com.example.fakecms.infrastructure.book.dto.BookPageDto;
import com.example.fakecms.infrastructure.book.entity.Book;
import com.example.fakecms.infrastructure.book.service.BookService;
import com.example.fakecms.vo.UnifyResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/list")
    @Operation(summary = "查询所有书籍信息")
    public UnifyResponseVO<Object> queryBookPage(@RequestBody BookPageDto bookPageDto){
        IPage<Book> queryPage = bookService.queryBookPage(bookPageDto);
        UnifyResponseVO<Object> responseVO = new UnifyResponseVO<>();
        responseVO.setMessage(queryPage.getRecords());
        return responseVO;
    }

    @DeleteMapping("{bookId}")
    @Operation(summary = "书籍管理根据id删除")
    public UnifyResponseVO deleteByBookId(@PathVariable String bookId) {
        bookService.removeById(bookId);
        return new UnifyResponseVO<>("删除成功");
    }

    @PutMapping("{bookId}")
    @Operation(summary = "书籍管理根据id更新")
    public UnifyResponseVO updateByBookId(@PathVariable String bookId, @RequestBody Book book){
        if(!StringUtils.isEmpty(bookId)){
            boolean exist = bookService.checkDictExistByBookId(bookId);
            if(!exist) throw new NotFoundException(5005);
        }
        book.setId(bookId);
        bookService.updateById(book);
        return new UnifyResponseVO("更新成功");
    }
}
