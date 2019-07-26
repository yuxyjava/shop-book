package com.fh.shop.common;

import lombok.Data;

@Data
public class Page {

    private int draw;

    private int start = 0;

    private int length = 5;


}
