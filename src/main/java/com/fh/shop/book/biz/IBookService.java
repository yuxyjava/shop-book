package com.fh.shop.book.biz;

import com.fh.shop.book.param.BookParam;
import com.fh.shop.book.po.Book;
import com.fh.shop.common.ServerResponse;

public interface IBookService {

    public void addBook(Book book);

    ServerResponse findList(BookParam bookParam);

    ServerResponse delete(long id);

    ServerResponse deleteBatch(String ids);
}
