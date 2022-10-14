package com.example.myfirstcms.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LoginDTO {

//    @NotBlank(message = "{username.not-blank}")
    private String username;

//    @NotBlank(message = "{password.new.not-blank}")
    private String password;

    private String captcha;
}
