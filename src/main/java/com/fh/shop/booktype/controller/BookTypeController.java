package com.fh.shop.booktype.controller;

import com.fh.shop.booktype.biz.IBookTypeService;
import com.fh.shop.common.ServerResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/booktypes")
@CrossOrigin("http://localhost:8084")
public class BookTypeController {
    @Resource(name = "bookTypeService")
    private IBookTypeService bookTypeService;

    @GetMapping
    public ServerResponse list() {
        return bookTypeService.findBookTypeList();
    }
}
