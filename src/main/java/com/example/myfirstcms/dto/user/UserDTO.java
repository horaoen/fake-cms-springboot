package com.example.myfirstcms.dto.user;

import com.example.myfirstcms.infrastructure.dict.annotation.Dict;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    /**
     * 用户名，唯一
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 头像url
     */
    private String avatar;

    /**
     *性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;
}
