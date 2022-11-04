package com.example.fakecms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@Builder
@TableName("lin_permission")
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDO extends BaseAllHave implements Serializable {

    private static final long serialVersionUID = -2400022443732120128L;

    /**
     * 权限名称，例如：访问首页
     */
    private String name;

    /**
     * 权限所属url地址
     */
    private String url;

    /**
     * 权限范围
     */
    private Boolean code;

}
