package com.example.fakecms.vo;

import com.example.fakecms.infrastructure.dict.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoVO {

    @Schema(name = "用户编号")
    private Integer id;

    @Schema(name = "用户名")
    private String username;

    @Schema(name = "昵称")
    private String nickname;

    @Schema(name = "性别码")
    @Dict(dictCode = "sex")
    private Integer sex;

    @Schema(name = "用户邮箱")
    private String email;

    private String avatar;


//    public List<RoleDO> roles;
//
//    public UserInfoVO(UserDO user, List<RoleDO> roles){
//        BeanUtils.copyProperties(user, this);
//        this.roles = roles;
//    }
}
