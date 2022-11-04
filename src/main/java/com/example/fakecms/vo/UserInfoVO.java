package com.example.fakecms.vo;

import com.example.fakecms.infrastructure.dict.annotation.Dict;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
