package com.fh.shop.book.param;

import com.fh.shop.common.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookParam extends Page implements Serializable {
    private static final long serialVersionUID = -6918939084729097234L;

    private String bookName;

    private Float minPrice;

    private Float maxPrice;


}
