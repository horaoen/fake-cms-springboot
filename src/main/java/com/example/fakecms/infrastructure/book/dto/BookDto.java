package com.example.fakecms.infrastructure.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookDto {

    @Schema(name = "书名")
    private String title;

    @Schema(name = "作者")
    private String author;

    @Schema(name = "封面url")
    private String cover;

    @Schema(name = "描述")
    private String description;
}
