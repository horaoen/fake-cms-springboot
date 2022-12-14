package com.example.fakecms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("lin_user")
public class UserDO extends BaseAllHave implements Serializable {


    private static final long serialVersionUID = -8525868757144855963L;
    /**
     * 用户名，唯一
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 加盐
     */
    private String salt;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

}
