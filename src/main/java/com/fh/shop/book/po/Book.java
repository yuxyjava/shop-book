package com.fh.shop.book.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = -2692490088269663446L;

    private Integer id;

    private String bookName;

    private Float price;

    private Long typeId;
    @TableField(exist = false)
    private String typeName;
}
