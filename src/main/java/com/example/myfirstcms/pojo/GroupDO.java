package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.example.myfirstcms.common.enumeration.GroupLevelEnum;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lin_group")
public class GroupDO extends BaseAllHave implements Serializable {

    private static final long serialVersionUID = -8994898895671436007L;

    /**
     * 分组名称，例如：搬砖者
     */
    private String name;

    /**
     * 分组信息：例如：搬砖的人
     */
    private String info;

    /**
     * 分组级别（root、guest、user，其中 root、guest 分组只能存在一个）
     */
    @TableField(value = "`level`")
    private GroupLevelEnum level;

}