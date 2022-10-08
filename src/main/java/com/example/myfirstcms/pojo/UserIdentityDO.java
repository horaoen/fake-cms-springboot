package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("lin_user_identity")
public class UserIdentityDO extends BaseAllHave implements Serializable {


    private static final long serialVersionUID = -2854908150563920910L;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 认证类型，例如 username_password，用户名-密码认证
     */
    private String identityType;

    /**
     * 认证，例如 用户名
     */
    private String identifier;

    /**
     * 凭证，例如 密码
     */
    private String credential;
}
