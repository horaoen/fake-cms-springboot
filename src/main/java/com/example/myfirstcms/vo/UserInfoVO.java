package com.example.myfirstcms.vo;

import com.example.myfirstcms.infrastructure.dict.annotation.Dict;
import com.example.myfirstcms.pojo.RoleDO;
import com.example.myfirstcms.pojo.UserDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoVO {

    private Integer id;

    private String username;

    private String nickname;

    @Dict(dictCode = "sex")
    private Integer sex;

    private String email;

    private String avatar;


//    public List<RoleDO> roles;
//
//    public UserInfoVO(UserDO user, List<RoleDO> roles){
//        BeanUtils.copyProperties(user, this);
//        this.roles = roles;
//    }
}