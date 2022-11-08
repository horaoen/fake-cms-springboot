package com.example.fakecms.infrastructure.book.dto;

import lombok.Data;

@Data
public class BookPageDto {
    private int pageNo = 1;

    private int pageSize = 10;
}
