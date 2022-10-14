package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("lin_group_permission")
public class RolePermissionDO implements Serializable {

    private static final long serialVersionUID = -358487811336536495L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分组id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permissionId;

}
