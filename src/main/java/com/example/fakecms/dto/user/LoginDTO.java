package com.example.fakecms.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = "{username.not-blank}")
    @Schema(name = "用户名")
    private String username;

    @NotBlank(message = "{password.new.not-blank}")
    @Schema(name = "密码")
    private String password;

    @Schema(name = "验证码")
    private String captcha;
}
