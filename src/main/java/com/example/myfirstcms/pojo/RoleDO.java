package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lin_role")
public class RoleDO extends BaseAllHave implements Serializable {

    private static final long serialVersionUID = -8994898895671436007L;

    /**
     * 分组名称，例如：搬砖者
     */
    private String name;

    /**
     * 分组信息：例如：搬砖的人
     */
    private String note;

    /**
     * 状态
     * 1正常 0禁用
     */
    private Integer status;


}