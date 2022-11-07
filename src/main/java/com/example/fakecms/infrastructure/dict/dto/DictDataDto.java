package com.example.fakecms.infrastructure.dict.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DictDataDto {
    @Schema(name = "字典编码")
    private String dictCode;

    @Schema(name = "key")
    private String dictKey;

    @Schema(name = "value")
    private String dictValue;

    @Schema(name = "数据描述信息")
    private String dataDesc;
}
