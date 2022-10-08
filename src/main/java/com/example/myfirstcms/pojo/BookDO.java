package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("book")
public class BookDO extends BaseAllHave implements Serializable {
    private static final long serialVersionUID = 4204868550123298996L;

    private String title;

    private String author;

    private String summary;

    private String image;
}
