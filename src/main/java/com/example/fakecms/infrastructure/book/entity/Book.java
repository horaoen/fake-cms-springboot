package com.example.fakecms.infrastructure.book.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class Book {

    @TableId(type = IdType.AUTO)
    private String id;

    private String title;

    private String author;

    private String cover;

    private String description;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private String deleted;
}
