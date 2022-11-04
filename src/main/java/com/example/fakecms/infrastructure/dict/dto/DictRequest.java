package com.example.fakecms.infrastructure.dict.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DictRequest {
    @Schema(name = "字典编码")
    private String dictCode;

    @Schema(name = "字典名称")
    private String dictName;

    private int pageNo = 1;

    private int pageSize = 10;
}
