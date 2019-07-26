package com.fh.shop.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.shop.book.mapper.IBookMapper;
import com.fh.shop.book.param.BookParam;
import com.fh.shop.book.po.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-common.xml"})
public class TestBookMapper extends AbstractJUnit4SpringContextTests {
    @Autowired
    public IBookMapper bookMapper;

    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setBookName("ddd");
        book.setTypeId(1L);
        book.setPrice(35f);
        bookMapper.addBook(book);
    }

    @Test
    public void testAddBook1() {
        Book book = new Book();
        book.setBookName("ccc");
        book.setTypeId(2L);
        book.setPrice(38f);
        bookMapper.insert(book);
    }

    @Test
    public void testSelectBooks() {
        Book book = bookMapper.selectById(5);
        System.out.println(book);
    }

    @Test
    public void testSelect2() {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<Book>()
                .eq("id", 5);

        //List<Book> books = bookMapper.selectList(bookQueryWrapper);
        Book book = bookMapper.selectOne(bookQueryWrapper);
        System.out.println(book);
    }

    @Test
    public void testSelect3() {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<Book>()
                .ge("price", 35)
                .le("price", 45)
                .like("bookname", "3");

        List<Book> books = bookMapper.selectList(bookQueryWrapper);
        System.out.println(books);
    }

    @Test
    public void test4() {
        Page<Book> bookPage = new Page<>();
        // 第几页
        bookPage.setCurrent(1);
        // 每页有几条
        bookPage.setSize(2);
        IPage<Book> bookIPage = bookMapper.selectPage(bookPage, null);
        System.out.println(bookIPage);
    }

    @Test
    public void test5() {
        int i = bookMapper.deleteById(9);
        System.out.println(i);
    }

    @Test
    public void test6() {
        List<Integer> idList = new ArrayList<>();
        idList.add(10);
        idList.add(12);
        int i = bookMapper.deleteBatchIds(idList);
        System.out.println(i);
    }

    @Test
    public void test7() {
        Book book = new Book();
        book.setId(15);
        book.setBookName("红刘国华");
        bookMapper.updateById(book);
    }

    @Test
    public void test8() {
        UpdateWrapper<Book> bookQueryWrapper = new UpdateWrapper<Book>()
                .ge("price", 35)
                .le("price", 45)
                .like("bookname", "3");
        Book book = new Book();
        book.setPrice(100f);
        int update = bookMapper.update(book, bookQueryWrapper);
        System.out.println(update);
    }

    @Test
    public void test9() {
        BookParam bookParam = new BookParam();
        bookParam.setBookName("3");
        bookParam.setMinPrice(100f);
        bookParam.setMaxPrice(200f);
        List<Book> bookList = bookMapper.findBookList(bookParam);
        System.out.println(bookList);
    }









}
