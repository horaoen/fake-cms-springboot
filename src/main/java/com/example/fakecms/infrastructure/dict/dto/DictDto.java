package com.example.fakecms.infrastructure.dict.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DictDto {
    @Schema(name = "字典编码")
    private String dictCode;

    @Schema(name = "字典名称")
    private String dictName;

    @Schema(name = "数据描述信息")
    private String dataDesc;
}
