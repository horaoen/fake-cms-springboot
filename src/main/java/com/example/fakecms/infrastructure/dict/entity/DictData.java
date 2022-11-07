package com.example.fakecms.infrastructure.dict.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dict_data")
public class DictData {
    @TableId(type = IdType.AUTO)
    private String id;

    @Schema(name = "字典编码")
    private String dictCode;

    @Schema(name = "key")
    private String dictKey;

    @Schema(name = "value")
    private String dictValue;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic(value = "0", delval = "1")
    private String deleted;

    @Schema(name = "数据描述信息")
    private String dataDesc;
}
