package com.fh.shop.booktype.biz;

import com.fh.shop.book.mapper.IBookMapper;
import com.fh.shop.book.po.Book;
import com.fh.shop.booktype.mapper.BookTypeMapper;
import com.fh.shop.booktype.po.BookType;
import com.fh.shop.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookTypeService")
public class IBookTypeServiceImpl implements IBookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public ServerResponse findBookTypeList() {
        List<BookType> bookTypes = bookTypeMapper.selectList(null);
        return ServerResponse.success(bookTypes);
    }
}
