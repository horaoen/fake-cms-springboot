package com.example.myfirstcms.infrastructure.dict.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dict")
public class Dict {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(name = "字典编码")
    private String dictCode;

    @Schema(name = "字典名称")
    private String dictName;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private String deleted;

    @Schema(name = "字典描述信息")
    private String dictDesc;
}
