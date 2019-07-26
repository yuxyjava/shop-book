package com.fh.shop.book.biz;

import com.fh.shop.book.mapper.IBookMapper;
import com.fh.shop.book.param.BookParam;
import com.fh.shop.book.po.Book;
import com.fh.shop.common.DataTableResult;
import com.fh.shop.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("bookService")
public class IBookServiceImpl implements IBookService {
    @Autowired
    private IBookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public ServerResponse findList(BookParam bookParam) {
        // 查询总条数
        long totalCount = bookMapper.findBookCount(bookParam);
        // 获取分页列表
        List<Book> bookList = bookMapper.findBookList(bookParam);
        DataTableResult dataTableResult = new DataTableResult(bookParam.getDraw(), totalCount, bookList);
        return ServerResponse.success(dataTableResult);
    }

    @Override
    public ServerResponse delete(long id) {
        bookMapper.deleteById(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBatch(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return ServerResponse.error();
        }
        String[] idArr = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String s : idArr) {
            idList.add(Integer.parseInt(s));
        }
        bookMapper.deleteBatchIds(idList);
        return ServerResponse.success();
    }
}
