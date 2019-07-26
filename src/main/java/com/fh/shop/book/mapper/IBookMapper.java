package com.fh.shop.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.shop.book.param.BookParam;
import com.fh.shop.book.po.Book;

import java.util.List;

public interface IBookMapper extends BaseMapper<Book> {

    public void addBook(Book book);

    public List<Book> findBookList(BookParam bookParam);

    long findBookCount(BookParam bookParam);
}
