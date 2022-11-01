package com.example.myfirstcms.infrastructure.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private String deleted;

    @Schema(name = "字典描述信息")
    private String dictDesc;
}
