package com.fh.shop.book.controller;

import com.fh.shop.book.biz.IBookService;
import com.fh.shop.book.param.BookParam;
import com.fh.shop.book.po.Book;
import com.fh.shop.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/books")
@CrossOrigin("http://localhost:8084")
public class BookController {
    @Resource(name = "bookService")
    private IBookService bookService;

    @PostMapping
    public ServerResponse add(@RequestBody Book book) {
        bookService.addBook(book);
        return ServerResponse.success();
    }

    @GetMapping
    public ServerResponse list(BookParam bookParam) {
        return bookService.findList(bookParam);
    }

    @DeleteMapping("/{id}")
    public ServerResponse delete(@PathVariable long id) {
        return bookService.delete(id);
    }

    @DeleteMapping
    public ServerResponse deleteBatch(String ids) {
        return  bookService.deleteBatch(ids);
    }


}
